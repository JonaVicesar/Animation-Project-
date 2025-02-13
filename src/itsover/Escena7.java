package itsover;

import uwcse.graphics.GWindow;

/**
 * Clase Escena7: representa una escena de transición que muestra un cartel.
 * 
 * @author Jona Vicesar
 */
public class Escena7 extends Escena {

    private GWindow ventana;

    /**
     * constructor de la escena.
     *
     * @param ventana ventana grafica donde se reproducirá la escena.
     * @throws InterruptedException si la ejecución de un hilo es interrumpida.
     */
    public Escena7(GWindow ventana) throws InterruptedException {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     *reproduce la escena mostrando un cartel de transición.
     *
     * @throws InterruptedException si la ejecución de un hilo es interrumpida.
     */
    @Override
    public void reproducir() throws InterruptedException {
        mostrarCartelDeTransicion();
    }

    /**
     * muestra el cartel de transicion correspondiente a esta escena.
     *
     * @throws InterruptedException Si la ejecución de un hilo es interrumpida.
     */
    private void mostrarCartelDeTransicion() throws InterruptedException {
        Transicion partThree = new Transicion(ventana);
        partThree.partThreeCartel();
    }
}
