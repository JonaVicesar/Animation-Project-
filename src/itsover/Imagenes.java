package itsover;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import uwcse.graphics.GWindow;
import uwcse.graphics.ImageShape;

/**
 *clase para manejar imágenes en una ventana gráfica.
 * permite mostrar, mover, redimensionar y quitar imágenes.
 * 
 * @author Jona
 */
public class Imagenes {
    private Image imagen_1; // Imagen cargada
    private ImageShape imagen; // Forma gráfica de la imagen

    /**
     * constructor que carga y centra automáticamente una imagen en la ventana.
     * 
     * @param nombreImagen Nombre del archivo de imagen (con extensión).
     * @param ventana Ventana donde se mostrará la imagen.
     * @throws IOException Si ocurre un error al cargar la imagen.
     */
    public Imagenes(String nombreImagen, GWindow ventana) throws IOException {
        this.imagen_1 = ImageIO.read(this.getClass()
                                         .getClassLoader()
                                         .getResource("imagenes" + File.separator + nombreImagen));
        int imgAncho = imagen_1.getWidth(null);
        int imgAlto = imagen_1.getHeight(null);
        int centroX = (ventana.getWindowWidth() - imgAncho) / 2;
        int centroY = (ventana.getWindowHeight() - imgAlto) / 2;
        this.imagen = new ImageShape(imagen_1, centroX, centroY);
    }

    /**
     * constructor que carga una imagen con tamaño y posición específicos.
     * 
     * @param nombreImagen Nombre del archivo de imagen con su extencion.
     * @param ventana Ventana donde se mostrara la imagen.
     * @param posX Coordenada X donde estará la imagen.
     * @param posY Coordenada Y donde estará la imagen.
     * @param ancho Ancho de la imagen.
     * @param alto Alto de la imagen.
     * @throws IOException Si ocurre un error al cargar la imagen.
     */
    public Imagenes(String nombreImagen, GWindow ventana, int posX, int posY, int ancho, int alto) throws IOException {
        this.imagen_1 = ImageIO.read(this.getClass()
                                         .getClassLoader()
                                         .getResource("imagenes" + File.separator + nombreImagen));
        this.imagen_1 = imagen_1.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        this.imagen = new ImageShape(imagen_1, posX, posY);
    }

    /**
     * redimensiona la imagen al tamaño especificado.
     * 
     * @param ancho nuevo ancho de la imagen.
     * @param alto nuevo alto de la imagen.
     * @return imagen redimensionada.
     */
    public ImageShape redimensionar(int ancho, int alto) {
        if (imagen_1 != null) {
            this.imagen_1 = imagen_1.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            this.imagen = new ImageShape(imagen_1, 0, 0);
        }
        return imagen;
    }

    /**
     * muestra la imagen en la ventana.
     * 
     * @param ventana Ventana donde se mostrará la imagen.
     */
    public void mostrar(GWindow ventana) {
        if (imagen != null) {
            imagen.addTo(ventana);
        }
    }

    /**
     * Elimina la imagen de la ventana.
     */
    public void quitar() {
        if (imagen != null) {
            imagen.removeFromWindow();
        }
    }

    /**
     * Mueve la imagen en la ventana según los desplazamientos en X y Y.
     * 
     * @param dx Desplazamiento en X.
     * @param dy Desplazamiento en Y.
     */
    public void mover(int dx, int dy) {
        if (imagen != null) {
            imagen.moveBy(dx, dy);
        }
    }
}
