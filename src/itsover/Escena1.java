package itsover;

import uwcse.graphics.GWindow;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import uwcse.graphics.TextShape;

/**
 * representa la primera escena de la animación.
 * 
 */
public class Escena1 extends Escena {
    private final GWindow ventana;
    private final Font fuenteTexto = new Font("Courier New", Font.BOLD, 36);
    private final Font fuenteTitulo = new Font("Courier New", Font.PLAIN, 62);
    private final Color colorTexto = Color.WHITE;

    public Escena1(GWindow ventana) {
        super(ventana);
        this.ventana = ventana;
    }

    /**
     * metodo principal que ejecuta toda la lógica de la escena.
     */
    @Override
    public void reproducir() throws IOException, InterruptedException {
        Imagenes city = inicializarEscena();
        mostrarTextosIniciales();
        moverCamara(city, 2, 290);
        mostrarTituloFinal();
    }

    /**
     * cnfigura los elementos iniciales de la escena, como el fondo y la música.
     */
    private Imagenes inicializarEscena() throws IOException {
        Imagenes city = new Imagenes("city.png", ventana, 0, 90, ventana.getWindowWidth(), ventana.getWindowHeight() - 100);
        NocheEstrellada escena1 = new NocheEstrellada(ventana);

        city.mostrar(ventana);
        ventana.doRepaint();

        Musica cityOfStars = new Musica("City Of Stars Whistle.wav");
        cityOfStars.reproducir();

        return city;
    }

    /**
     * muestra los textos iniciales de créditos en la pantalla con pausas.
     */
    private void mostrarTextosIniciales() throws InterruptedException {
        TextShape[] textos = {
            crearTexto("A movie by", 900, 250, fuenteTexto),
            crearTexto("Jona Vicesar", 897, 289, fuenteTexto),
            crearTexto("Starring by", 115, 289, fuenteTexto),
            crearTexto("Leonardo De Niro", 115, 292, fuenteTexto),
            crearTexto("Meryl Stone", 897, 289, fuenteTexto)
        };

        mostrarTextoConPausa(textos[0], textos[1], 4000);
        mostrarTextoConPausa(textos[2], null, 2000);
        mostrarTextoConPausa(textos[3], null, 2000);
        mostrarTextoConPausa(textos[4], null, 2000);
    }

    /**
     * crea un texto con las propiedades especificadas.
     *
     * @param contenido Contenido del texto.
     * @param x Posición X.
     * @param y Posición Y.
     * @param fuente Fuente del texto.
     * @return El objeto TextShape creado.
     */
    private TextShape crearTexto(String contenido, int x, int y, Font fuente) {
        TextShape texto = new TextShape(contenido, x, y, colorTexto);
        texto.setFont(fuente);
        return texto;
    }

    /**
     * muestra un texto en la ventana y espera un tiempo antes de eliminarlo.
     *
     * @param texto1 Primer texto a mostrar.
     * @param texto2 Segundo texto opcional.
     * @param duracion Tiempo en milisegundos antes de eliminarlos.
     */
    private void mostrarTextoConPausa(TextShape texto1, TextShape texto2, int duracion) throws InterruptedException {
        texto1.addTo(ventana);
        if (texto2 != null) texto2.addTo(ventana);

        Thread.sleep(duracion);

        texto1.removeFromWindow();
        if (texto2 != null) texto2.removeFromWindow();
    }

    /**
     * simula el movimiento de la camara desplazando los objetos 
     *
     * @param city la imagen de la ciudad.
     * @param velocidad cantidad de píxeles que se mueve en cada iteración.
     * @param pasos numero total de iteraciones.
     */
    private void moverCamara(Imagenes city, int velocidad, int pasos) {
        for (int i = 0; i < pasos; i++) {
            city.mover(0, velocidad);
            ventana.doRepaint();
            try {
                Thread.sleep(55); // Control de la velocidad de movimiento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * myestra el título de la película.
     */
    private void mostrarTituloFinal() throws InterruptedException {
        TextShape titulo = crearTexto("It's Over", ventana.getWindowWidth() / 2, ventana.getWindowHeight() / 2, fuenteTitulo);
        titulo.addTo(ventana);
        ventana.doRepaint();

        Thread.sleep(1500);
        titulo.removeFromWindow();
    }
}
