package itsover;

import java.io.IOException;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;

/**
 * @author Jona Vicesar
 */
public class Escena9  extends Escena{

    private GWindow ventana;

    public Escena9(GWindow ventana) {
        super(ventana);
        this.ventana = ventana;

    }

    @Override
    public void reproducir() throws IOException, InterruptedException {
        // Configurar y mostrar elementos visuales
        mostrarElementosFinales();

        // Mostrar el diálogo final después de una pausa
        Thread.sleep(6000);
        mostrarFraseFinal();
    }

    /**
     * configura y muestra los elementos gráficos finales de la escena.
     */
    private void mostrarElementosFinales() throws IOException {
        // Crear un árbol, un risco y el fondo de estrellas
        Imagenes arbol = new Imagenes("lapachoRosa22.png", ventana, 40, 388, 150, 280);
        Rectangle risco = new Rectangle(0, 630, ventana.getWindowWidth(), 300, java.awt.Color.BLACK, true);
        NocheEstrellada medianoche = new NocheEstrellada(ventana);

        // Mostrar el personaje final y los elementos gráficos
        Imagenes tomFinal = new Imagenes("tom2.png", ventana, 152, 500, 350, 150);
        risco.addTo(ventana);
        tomFinal.mostrar(ventana);
        arbol.mostrar(ventana);
    }

    /**
     * muestra el diaogo final de la escena.
     */
    private void mostrarFraseFinal() {
        Dialogo fraseFinal = new Dialogo(ventana);
        fraseFinal.mostrarFraseFinal();
    }

}
