package itsover;

import uwcse.graphics.GWindow;
import java.awt.Color;
import java.awt.Font;
import uwcse.graphics.TextShape;

/**
 * Esta clase contiene métodos que son utilizados en las escenas de la animación
 * donde aparecen textos.
 *
 * @author Jona Vicesar
 */
public class Transicion {

    private final GWindow ventana;
    /**
     * Constructor que inicializa la ventana para mostrar los carteles.
     *
     * @param ventana La ventana donde se mostrarán los carteles.
     */
    public Transicion(GWindow ventana) {
        this.ventana = ventana;
    }
    /**
     * Muestra el cartel "Part One" con rectángulos vibrando en el fondo.
     *
     * @throws InterruptedException Si se interrumpe la pausa entre acciones.
     */
    public void partOneCartel() throws InterruptedException {
        FigurasGeometricas fondo = new FigurasGeometricas(ventana);
        fondo.rectangulosEsparcidos(60);
        fondo.iniciarVibracion();
        fondo.mostrarFiguras();

        TextShape titulo = crearTexto("Part One",(ventana.getWindowWidth() / 2) - 30,
                                                  ventana.getWindowHeight() / 2);
        
        TextShape subtitulo = crearTexto("Drown", (ventana.getWindowWidth() / 2) - 30,
                                                   ventana.getWindowHeight() / 2);

        titulo.addTo(ventana);
        Thread.sleep(1500);
        titulo.removeFromWindow();
        subtitulo.addTo(ventana);
    }

    /**
     * Muestra el cartel "Part Two" con óvalos vibrando en el fondo.
     *
     * @throws InterruptedException Si se interrumpe la pausa entre acciones.
     */
    public void partTwoCartel() throws InterruptedException {
        FigurasGeometricas fondo = new FigurasGeometricas(ventana);
        fondo.ovalosEsparcidos();
        fondo.iniciarVibracion();
        fondo.mostrarFiguras();

        TextShape titulo = crearTexto("Part Two", (ventana.getWindowWidth() / 2) - 30, 
                                                   ventana.getWindowHeight() / 2);
        
        TextShape subtitulo = crearTexto("Until She Arrived", (ventana.getWindowWidth() / 2) - 30, 
                                                               ventana.getWindowHeight() / 2);
        
        titulo.addTo(ventana);
        Thread.sleep(1500);
        titulo.removeFromWindow();
        subtitulo.addTo(ventana);
    }

    /**
     * Muestra el cartel "Part Three" con rectángulos vibrando en el fondo.
     */
    public void partThreeCartel()throws InterruptedException {
        FigurasGeometricas fondo = new FigurasGeometricas(ventana);
        fondo.triangulosEsparcidos();
        fondo.iniciarVibracion();
        fondo.mostrarFiguras();

        TextShape titulo = crearTexto("Part Three", (ventana.getWindowWidth() / 2) - 30,
                                                     ventana.getWindowHeight() / 2);
        
        TextShape subtitulo = crearTexto("Even Nice Things",(ventana.getWindowWidth() / 2) - 30,    
                                                             ventana.getWindowHeight() / 2);
        
        TextShape subtitulo2 = crearTexto("End", (ventana.getWindowWidth() / 2) - 30, 
                                                   ventana.getWindowHeight() / 2 + 40);
        titulo.addTo(ventana);
        Thread.sleep(1500);
        titulo.removeFromWindow();
        subtitulo.addTo(ventana);
        subtitulo2.addTo(ventana);
    }

    /**
     * Crea un objeto de texto con un estilo predefinido.
     *
     * @param mensaje El mensaje a mostrar.
     * @return Un objeto TextShape configurado.
     */
    private TextShape crearTexto(String mensaje, int posX, int posY) {
        TextShape texto = new TextShape(mensaje, posX, posY, Color.BLACK);
        texto.setFont(new Font("Courier New", Font.BOLD, 56));
        return texto;
    }
}
