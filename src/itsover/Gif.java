package itsover;

import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;

/**
 * clase para reproducir un GIF animado en una ventana
 * 
 * @author Jona Vicesar
 */
public class Gif {

    private int contadorDeRepeticiones;
    private int repeticionActual;
    private final GWindow ventana;
    private final ArrayList<Image> frames;
    private ImageShape imagenActual;
    private int frameIndex;
    private final int delay;
    private Timer timer;
    private final Musica musica;

    /**
     * constructor de la clase Gif.
     *
     * @param ventana         ventana donde se mostrará el GIF.
     * @param nombresDeFrames lista de nombres de los frames.
     * @param carpeta         directorio donde se encuentran los frames.
     * @param delay           intervalo en milisegundos entre cada frame.
     * @param musica          objeto Musica para sincronizar audio con el GIF.
     */
    public Gif(GWindow ventana, ArrayList<String> nombresDeFrames, String carpeta, int delay, Musica musica) {
        this.ventana = ventana;
        this.frames = new ArrayList<>();
        this.delay = delay;
        this.contadorDeRepeticiones = 1;
        this.musica = musica;

        cargarFrames(nombresDeFrames, carpeta, ventana.getWindowWidth(), ventana.getWindowHeight());
    }

    /**
     * carga y redimensiona los frames del GIF.
     *
     * @param nombresDeFrames lista de nombres de los frames.
     * @param carpeta         directorio donde se encuentran los frames.
     * @param anchoDeseado    ancho deseado para los frames.
     * @param altoDeseado     alto deseado para los frames.
     */
    private void cargarFrames(ArrayList<String> nombresDeFrames, String carpeta, int anchoDeseado, int altoDeseado) {
        for (String nombre : nombresDeFrames) {
            try {
                Image img = ImageIO.read(getClass()
                                   .getClassLoader()
                                   .getResource("imagenes" + File.separator + carpeta + File.separator + nombre));
                frames.add(img.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH));
            } catch (IOException e) {
                System.err.println("Error al cargar la imagen: " + nombre);
            }
        }
    }

    /**
     * muestra el frame actual centrado en la pantalla.
     */
    private void mostrarFrameActual() {
        Image frame = frames.get(frameIndex);
        int centradoEnX = (ventana.getWindowWidth() - frame.getWidth(null)) / 2;
        int centradoEnY = (ventana.getWindowHeight() - frame.getHeight(null)) / 2;
        
        imagenActual = new ImageShape(frame, centradoEnX, centradoEnY);
        ventana.erase(); // borra el frame anterior.
        ventana.add(imagenActual);
        ventana.doRepaint();
    }

    /**
     * reproduce el GIF el número de veces indicado.
     *
     * @param repeatCount numero de repeticiones del GIF.
     */
    public void reproducir(int repeatCount) {
        this.contadorDeRepeticiones = repeatCount;
        this.repeticionActual = 0;
        this.frameIndex = 0;

        detenerTimer();

        if (musica != null) {
            musica.reproducir(); // inicia la música junto con el GIF
        }

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mostrarFrameActual();
                frameIndex++;

                if (frameIndex >= frames.size()) {
                    frameIndex = 0;
                    repeticionActual++;

                    if (repeticionActual >= contadorDeRepeticiones) {
                        parar();
                    }
                }
            }
        }, 0, delay);
    }

    /**
     * detiene la reproducción del GIF y la música asociada
     */
    public void parar() {
        detenerTimer();
        if (musica != null) {
            musica.parar(); // Detiene la música
        }
        ventana.erase();
        ventana.doRepaint();
    }

    /**
     * detiene el temporizador del GIF si está activo
     */
    private void detenerTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }
}
