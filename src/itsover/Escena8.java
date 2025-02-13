package itsover;

import java.util.ArrayList;
import java.io.IOException;
import uwcse.graphics.GWindow;

/**
 *  representa una escena que incluye un GIF animado
 * 
 * @author Jona Vicesar
 */
public class Escena8 extends Escena {

    private GWindow ventana;

    /**
     * constructor de la escena.
     *
     * @param ventana ventana gráfica donde se reproducirá la escena.
     * @throws IOException ssi ocurre un error al cargar recursos.
     * @throws InterruptedException si la ejecucion de un hilo es interrumpida.
     */
    public Escena8(GWindow ventana) throws IOException, InterruptedException {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * reproduce la escena, mostrando graficos y ejecutando animaciones.
     *
     * @throws IOException si ocurre un error al cargar archivos multimedia.
     * @throws InterruptedException si la ejecucion de un hilo es interrumpida.
     */
    @Override
    public void reproducir() throws IOException, InterruptedException {
        // Inicializar música y animación GIF
        Musica musica = inicializarMusica();
        Gif gif = inicializarGif(musica);

        //eeproducir el GIF con música
        gif.reproducir(1);

    }

    /**
     * Inicializa la música para la escena.
     *
     * @return instancia de la clase Musica.
     * @throws IOException si no se encuentra el archivo de música.
     */
    private Musica inicializarMusica() throws IOException {
        return new Musica("epilogue.wav");
    }

    /**
     * inicializa el GIF que se muestra en la escena.
     *
     * @param musica la musica asociada al GIF.
     * @return instancia de la clase Gif.
     */
    private Gif inicializarGif(Musica musica) {
        ArrayList<String> frames = new ArrayList<>();
        for (int i = 1; i < 194; i++) {
            frames.add(i + ".png");
        }
        return new Gif(ventana, frames, "part3", 100, musica);
    }


 

}
