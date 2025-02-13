package itsover;

import java.io.IOException;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import uwcse.graphics.Shape;
import java.util.ArrayList;

/**
 * representa la segunda escena de la animación.
 */
public class Escena2 extends Escena {
    private final GWindow ventana;

    public Escena2(GWindow ventana) {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * metodo principal que ejecuta toda la lógica de la escena.
     */
    @Override
    public void reproducir() throws IOException, InterruptedException {
        // configuración inicial de la escena
        Musica partTwo = new Musica("Merry-Go-Round- Of-Life.wav");
        NocheEstrellada cielo = new NocheEstrellada(ventana); // Noche estrellada de fondo
        Imagenes arbol = inicializarArbol();
        Imagenes personaje = inicializarPersonaje();
        Rectangle risco = inicializarRisco();
        ArrayList<Shape> elementos = inicializarElementos(risco);

        // agregar elementos a la ventana
        partTwo.reproducir();
        agregarElementosAVentana(elementos);
        arbol.mostrar(ventana);
        personaje.mostrar(ventana);
        ventana.doRepaint();

        // movimiento ascendente
        moverElementosAscendente(elementos, personaje, arbol);

        
        ejecutarDialogo();
    }

    /**
     * inicializa el árbol en la escena.
     */
    private Imagenes inicializarArbol() throws IOException {
        return new Imagenes("lapachoRosa22.png", ventana, 40, ventana.getWindowHeight() + 10, 150, 280);
    }

    /**
     * inicializa al personaje en la escena.
     */
    private Imagenes inicializarPersonaje() throws IOException {
        return new Imagenes("tomandhd2.PNG", ventana, 160, ventana.getWindowHeight() + 100, 400, 190);
    }

    /**
     * inicializa el risco en la escena.
     */
    private Rectangle inicializarRisco() {
        return new Rectangle(0, ventana.getWindowHeight() + 250, ventana.getWindowWidth(), 300, java.awt.Color.BLACK, true);
    }

    /**
     * inicializa los elementos de la escena.
     */
    private ArrayList<Shape> inicializarElementos(Rectangle risco) {
        ArrayList<Shape> elementos = new ArrayList<>();
        elementos.add(risco);
        return elementos;
    }

    /**
     * agrega elementos de la escena a la ventana.
     */
    private void agregarElementosAVentana(ArrayList<Shape> elementos) {
        for (Shape elemento : elementos) {
            elemento.addTo(ventana);
        }
    }

    /**
     * mueve los elementos de la escena hacia arriba simulando un ascenso.
     */
    private void moverElementosAscendente(ArrayList<Shape> elementos, Imagenes personaje, Imagenes arbol) throws InterruptedException {
        Thread.sleep(1500); // Pausa inicial

        for (int i = 0; i < 100; i++) {
            for (Shape elemento : elementos) {
                elemento.moveBy(0, -3); // Mover hacia arriba
            }
            personaje.mover(0, -3); // Mover personaje hacia arriba
            arbol.mover(0, -3); // Mover árbol hacia arriba

            ventana.doRepaint();
            Thread.sleep(100); // Control de velocidad del movimiento
        }

        ventana.doRepaint();
        Thread.sleep(1500); // Pausa antes de iniciar el diálogo
    }

    /**
     * ejecuta el diálogo 
     */
    private void ejecutarDialogo() throws InterruptedException {
        Dialogo dialogo = new Dialogo(ventana);
        dialogo.conversacion(); // Inicia el diálogo
    }

}
