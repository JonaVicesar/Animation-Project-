package itsover;

import java.io.IOException;
import java.util.ArrayList;
import uwcse.graphics.GWindow;

/**
 * Clase Escena6: reproduce una escena con música y un GIF animado.
 * 
 * @author Jona Vicesar
 */
public class Escena6 extends Escena {

    private final GWindow ventana;

    /**
     *constructor de la escena.
     *
     * @param ventana ventana gráfica donde se reproducirá la escena.
     */
    public Escena6(GWindow ventana) {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * reproduce la escena con música y animación.
     *
     * @throws IOException ii ocurre un error al cargar los recursos de música.
     * @throws InterruptedException ii la ejecución del hilo es interrumpida.
     */
    @Override
    public void reproducir() throws IOException, InterruptedException {
        // inicializa la música y el GIF
        Musica musica = inicializarMusica();
        Gif gif = inicializarGif(musica);

        // reproduce el GIF con la música
        gif.reproducir(1);
    }

    /**
     * inicializa la musica para la escena.
     *
     * @return instancia de la clase Musica.
     * @throws IOException si ocurre un error al cargar el archivo de música.
     */
    private Musica inicializarMusica() throws IOException {
        return new Musica("algo-contigo-piano.wav");
    }

    /**
     * inicializa el GIF que se muestra en la escena.
     *
     * @param musica la musica asociada al GIF.
     * @return instancia de la clase Gif.
     */
    private Gif inicializarGif(Musica musica) {
        ArrayList<String> frames = new ArrayList<>();
        // carga los frames del GIF
        for (int i = 1; i < 464; i++) {
            frames.add(i + ".png");
        }
        return new Gif(ventana, frames, "part2", 100, musica);
    }
}
