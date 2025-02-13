package itsover;

import java.io.IOException;
import uwcse.graphics.GWindow;
import java.util.ArrayList;

/**
 * Clase Escena4: representa la cuarta escena de la animación
 * 
 * @author Jona Vicesar
 */
public class Escena4 extends Escena {
    private final GWindow ventana;

    /**
     * constructor de la escena.
     *
     * @param ventana La ventana donde se desarrolla la escena.
     */
    public Escena4(GWindow ventana) {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * metodo principal que ejecuta toda la lógica de la escena.
     *
     * @throws IOException si ocurre un error al cargar los recursos de música.
     * @throws InterruptedException Si la ejecución del hilo es interrumpida.
     */
    @Override
    public void reproducir() throws IOException, InterruptedException {
        // configuracion inicial
        Musica musica = inicializarMusica();
        Gif gif = inicializarGif(musica);

        // reproduccion del GIF
        gif.reproducir(1);
    }

    /**
     * Inicializa la música para la escena.
     *
     * @return instancia de la clase Musica.
     * @throws IOException Si no se encuentra el archivo de música.
     */
    private Musica inicializarMusica() throws IOException {
        return new Musica("Kanye-West-Runaway.wav");
    }

    /**
     * inicializa el GIF que se muestra en la escena.
     *
     * @param musica la musica asociada al GIF.
     * @return instancia de la clase Gif.
     */
    private Gif inicializarGif(Musica musica) {
        ArrayList<String> frames = new ArrayList<>();
        for (int i = 1; i < 354; i++) {
            frames.add(i + ".png");
        }
        return new Gif(ventana, frames, "part1", 100, musica);
    }
}
