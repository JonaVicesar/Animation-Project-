package itsover;

import uwcse.graphics.GWindow;
import java.io.IOException;

/**
 * Clase abstracta para representar una escena genérica.
 * 
 * @author Jona Vicesar
 */
public abstract class Escena {
    protected GWindow ventana;

    /**
     * Constructor de la clase Escena.
     * 
     * @param ventana La ventana gráfica donde se reproducirá la escena.
     */
    public Escena(GWindow ventana) {
        this.ventana = ventana;
    }

    /**
     * Método abstracto que cada escena específica debe implementar.
     * 
     * @throws InterruptedException
     * @throws IOException
     */
    public abstract void reproducir() throws InterruptedException, IOException;
}


