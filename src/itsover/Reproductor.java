package itsover;

import java.io.IOException;
import uwcse.graphics.GWindow;

/**
 * clase Reproductor: Coordina la reproducción de las escenas en orden
 * se encarga de controlar los tiempos entre cada escena
 * 
 * @author Jona Vicesar
 */
public class Reproductor {
    private final GWindow ventana;

    /**
     * constructor de la clase Reproductor.
     *
     * @param ventana La ventana gráfica donde se reproducirán las escenas.
     */
    public Reproductor(GWindow ventana) {
        this.ventana = ventana;
    }

    /**
     * reproduce todas las escenas en orden. Controla los tiempos entre escenas.
     * 
     * @throws IOException Si ocurre un error al cargar los recursos de las escenas.
     * @throws InterruptedException Si el hilo principal es interrumpido durante las pausas.
     */
    public void reproducir() throws IOException, InterruptedException {
        // Instanciar todas las escenas
        Escena1 escena1 = new Escena1(ventana);
        Escena2 escena2 = new Escena2(ventana);
        Escena3 escena3 = new Escena3(ventana);
        Escena4 escena4 = new Escena4(ventana);
        Escena5 escena5 = new Escena5(ventana);
        Escena6 escena6 = new Escena6(ventana);
        Escena7 escena7 = new Escena7(ventana);
        Escena8 escena8 = new Escena8(ventana);
        Escena9 escena9 = new Escena9(ventana);

        // Reproducir cada escena con los tiempos definidos
        escena1.reproducir();
        Thread.sleep(7000); 
        escena2.reproducir();
        Thread.sleep(5100); 
        escena3.reproducir();
        Thread.sleep(3000); 
        escena4.reproducir();
        Thread.sleep(37000); 
        escena5.reproducir();
        Thread.sleep(2500); 
        escena6.reproducir();
        Thread.sleep(50000);
        escena7.reproducir();
        Thread.sleep(3000); 
        escena8.reproducir();
        Thread.sleep(21000);
        escena9.reproducir();
    }
}
