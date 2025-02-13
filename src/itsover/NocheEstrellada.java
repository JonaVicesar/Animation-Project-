package itsover;

import java.awt.Color;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Oval;

/**
 * clase que representa una escena de noche estrellada en la ventana
 * 
 * @author Jona Vicesar
 */
public class NocheEstrellada {

    /**
     * constructor que configura la escena de la noche estrellada.
     * 
     * @param ventana La ventana donde se dibujarala escena.
     */
    public NocheEstrellada(GWindow ventana) {
        // configuracion del fondo (cielo de noche)
        Color cieloNoche = new Color(3, 18, 43);
        Rectangle cielo = new Rectangle(0, 0, ventana.getWindowWidth(), ventana.getWindowHeight(), cieloNoche, true);
        cielo.addTo(ventana);

        // configuracion de la luna
        Color colorLuna = new Color(250, 250, 252);
        Oval luna = new Oval(970, 20, 100, 100, colorLuna, true);
        luna.addTo(ventana);

        // configuracion de las estrellas
        FigurasGeometricas estrellas = new FigurasGeometricas(ventana);
        estrellas.rectangulosEsparcidos(200, 200, 200, 2, 2, Color.WHITE, true); // Ajusta el tamaño si lo deseas
        estrellas.mostrarFiguras();
        estrellas.iniciarVibracion();
    }
}
