package itsover;

import java.io.IOException;
import uwcse.graphics.GWindow;

/**
 * clase principal de la aplicación "ITsOVER".
 * 
 * esta clase inicializa la ventana gráfica y ejecuta la secuencia completa de 
 * reproducción de las escenas a través de la clase Reproductor.
 */
public class ITsOVER {

    public static void main(String[] args) throws IOException, InterruptedException {
        // crear una ventana grafica con dimensiones específicas
        GWindow ventana = new GWindow(1900, 680);

        // instanciar el reproductor que controla las escenas
        Reproductor itsOver = new Reproductor(ventana);

        // iniciar la reproduccion de las escenas
        itsOver.reproducir();
    }
}
