package itsover;

import uwcse.graphics.GWindow;
import java.io.IOException;
import java.util.ArrayList;

/**
 * representa la tercera escena de la animación.
 */
public class Escena3 extends Escena {
    private final GWindow ventana;

    /**
     * constructor para la escena 3.
     *
     * @param ventana La ventana donde se desarrolla la escena.
     */
    public Escena3(GWindow ventana) {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * metodo principal que ejecuta toda la logica de la escena.
     */
    @Override
    public void reproducir() throws IOException, InterruptedException {
        // Configuración inicial
        Musica musica = inicializarMusica();
        Gif gif = inicializarGif(musica);
        Transicion partOne = new Transicion(ventana);

        // reproducción del GIF
        gif.reproducir(1);
        musica.reproducir();

        // pausa antes de mostrar el cartel
        Thread.sleep(1100);

        // mostrar cartel
        partOne.partOneCartel();

    }

    /**
     * inicializa la música para la escena.
     *
     * @return instancia de la clase Musica
     * @throws IOException Si no se encuentra el archivo de música.
     */
    private Musica inicializarMusica() throws IOException {
        return new Musica("Kanye-West-Runaway1.wav");
    }

    /**
     * inicializa el GIF que se muestra en la escena.
     *
     * @param musica la musica asociada al GIF.
     * @return instancia de la clase Gif.
     */
    private Gif inicializarGif(Musica musica) {
        ArrayList<String> frames = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            frames.add(i + ".png");
        }
        return new Gif(ventana, frames, "boxeo", 90, musica);
    }
}
