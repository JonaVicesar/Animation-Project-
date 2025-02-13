package itsover;

import java.awt.Color;
import java.awt.Font;
import uwcse.graphics.GWindow;
import uwcse.graphics.Oval;
import uwcse.graphics.TextShape;

/**
 * Clase para gestionar diálogos en la animación.
 */
public class Dialogo {

    private final GWindow ventana;

    /**
     * Constructor que inicializa la ventana para los diálogos.
     *
     * @param ventana La ventana de la animación.
     */
    public Dialogo(GWindow ventana) {
        this.ventana = ventana;
    }

    /**
     * Muestra una conversación predefinida.
     *
     * @throws InterruptedException Si el hilo es interrumpido durante las pausas.
     */
    public void conversacion() throws InterruptedException {
        // Configuración de las frases y burbujas
        TextShape frase1 = new TextShape("it's a nice night", 215, 525, Color.WHITE);
        TextShape frase2 = new TextShape("yes...", 455, 525, Color.WHITE);
        TextShape frase3 = new TextShape("wanna go somewhere else?", 215, 525, Color.WHITE);
        TextShape frase4 = new TextShape("we can...", 215, 525, Color.WHITE);
        TextShape frase5 = new TextShape("it's okay here", 450, 525, Color.WHITE);
        TextShape frase6 = new TextShape("It's Over", 455, 525, Color.WHITE);
        TextShape frase7 = new TextShape("...", 215, 525, Color.WHITE); 

        Oval burbuja1 = new Oval(210, 490, 145, 95, Color.WHITE, false); // Burbuja para frase 1 y 3
        Oval burbuja2 = new Oval(445, 490, 130, 80, Color.WHITE, false); // Burbuja para frase 2 y 4

        // Personalización de fuentes
        Font fuente = new Font("Courier New", Font.BOLD, 16);
        Font fuente2 = new Font("Courier New", Font.BOLD, 28);
        
        frase1.setFont(fuente);
        frase2.setFont(fuente);
        frase3.setFont(fuente);
        frase4.setFont(fuente);
        frase5.setFont(fuente);
        frase6.setFont(fuente);
        frase7.setFont(fuente2);

        //Mostrar las frases una por una
        mostrarFrase(frase1, burbuja1, 2500);
        mostrarFrase(frase2, burbuja2, 3500);
        mostrarFrase(frase3, burbuja1, 4300);
        mostrarFrase(frase4, burbuja1, 2300);
        mostrarFrase(frase5, burbuja2, 5800);
        mostrarFrase(frase6, burbuja2, 6300);
        mostrarFrase(frase7, burbuja1, 6300);
    }

    /**
     * Muestra una frase con su burbuja en la ventana durante un tiempo especificado.
     *
     * @param frase   El texto a mostrar.
     * @param burbuja La burbuja asociada.
     * @param duracion Tiempo en milisegundos que se muestra la frase.
     * @throws InterruptedException Si el hilo es interrumpido.
     */
    private void mostrarFrase(TextShape frase, Oval burbuja, int duracion) throws InterruptedException {
        frase.addTo(ventana);
        burbuja.addTo(ventana);
        Thread.sleep(duracion);
        frase.removeFromWindow();
        burbuja.removeFromWindow();
    }
    
    /**
     * Frase utilizada en la escena8, escena Final
     */
    public void mostrarFraseFinal(){
        Font fuente2 = new Font("Courier New", Font.BOLD, 28);
        TextShape fraseFinal = new TextShape("Thank u", 215, 525, Color.WHITE);
        Oval burbuja = new Oval(205, 500, 130, 80, Color.WHITE, false);
        fraseFinal.setFont(fuente2);
        fraseFinal.addTo(ventana);
        burbuja.addTo(ventana);
    }

}
