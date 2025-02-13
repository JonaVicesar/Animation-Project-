package itsover;

import uwcse.graphics.GWindow;

/**
 * Clase Escena5: reproduce una escena que muestra el cartel de la segunda parte.
 * 
 * @author Jona Vicesar
 */
public class Escena5 extends Escena {

    private final GWindow ventana;

    /**
     * constructor de la escena.
     *
     * @param ventana Ventana donde se reproducira la escena.
     * @throws InterruptedException Si ocurre una interrupcion durante la inicialización.
     */
    public Escena5(GWindow ventana) throws InterruptedException {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * reproduce la escena mostrando el cartel de la segunda parte.
     *
     * @throws InterruptedException Si la ejecución del hilo es interrumpida.
     */
    @Override
    public void reproducir() throws InterruptedException {
        Transicion partTwo = new Transicion(ventana);
        partTwo.partTwoCartel();
    }
}
