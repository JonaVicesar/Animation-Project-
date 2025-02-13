package itsover;

import java.awt.Color;
import java.util.ArrayList;
import uwcse.graphics.GWindow;
import uwcse.graphics.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import uwcse.graphics.Oval;
import uwcse.graphics.Triangle;

/**
 *
 * @author Jona Vicesar
 */
public class FigurasGeometricas {

    private GWindow ventana;
    private ArrayList<Rectangle> rectangulos;
    private ArrayList<Triangle> triangulos;
    private ArrayList<Oval> ovalos;
    private Random numero;
    private Timer timer;
    private Color color;

    /**
     *
     * @param ventana ventana en que mostraran las figuras
     */
    public FigurasGeometricas(GWindow ventana) {
        this.ventana = ventana;
        rectangulos = new ArrayList<Rectangle>();
        triangulos = new ArrayList<Triangle>();
        ovalos = new ArrayList<Oval>();
        numero = new Random();

    }

    /**
     * crea rectangulos en posiciones aleatorias en toda la pantalla
     *
     * @param cantRectangulos cantidad de rectangulos que se encontraran en la
     * pantalla
     * @return
     */
    public ArrayList<Rectangle> rectangulosEsparcidos(int cantRectangulos) {
        rectangulos.clear();
        for (int i = 0; i < cantRectangulos; i++) {
            int numeroAleatotioX = numero.nextInt(ventana.getWindowWidth());
            int numeroAleatotioY = numero.nextInt(ventana.getWindowHeight());
            int alturaAleatoria = 20 + numero.nextInt(50); //se suma 20 para evitar rectangulos muy chicos o tamano cero
            int anchoAleatorio = 20 + numero.nextInt(50);
            rectangulos.add(new Rectangle(numeroAleatotioX, numeroAleatotioY, alturaAleatoria, anchoAleatorio));

        }
        return rectangulos;
    }

    /**
     * crea rectangulos en posiciones aleatorias en un rango detereminado por si
     * posicion en X e Y y tamano promedio dado
     *
     * @param cantidadRectangulos cantidad de rectagnulos que se mostraran
     * @param posicionX posicion en X(los rectangulos solo apareceran alrededor
     * de esta posicion)
     * @param posicionY posicion en Y(los rectangulos solo apareceran alrededor
     * de esta posicion)
     * @param tamX
     * @param tamY
     * @param color
     * @return
     */
    public ArrayList<Rectangle> rectangulosEsparcidos(int cantidadRectangulos, int posicionX, int posicionY, int tamX, int tamY, Color color) {
        rectangulos.clear();
        for (int i = 0; i < cantidadRectangulos; i++) {
            int numeroAleatorioX = posicionX + numero.nextInt(100) - 50;
            int numeroAleatorioY = posicionY + numero.nextInt(100) - 50;

            int alturaAleatoria = 1 + numero.nextInt(tamX);
            int anchoAleatorio = 1 + numero.nextInt(tamY);

            numeroAleatorioX = Math.max(0, Math.min(numeroAleatorioX, ventana.getWindowWidth() - anchoAleatorio));
            numeroAleatorioY = Math.max(0, Math.min(numeroAleatorioY, ventana.getWindowHeight() - alturaAleatoria));

            Rectangle rect = new Rectangle(numeroAleatorioX, numeroAleatorioY, alturaAleatoria, anchoAleatorio);
            rect.setColor(color);  // Asigna el color pasado como parámetro
            rectangulos.add(rect);
        }
        return rectangulos;
    }

    /**
     *
     * @param cantidadRectangulos
     * @param posicionX
     * @param posicionY
     * @param tamX
     * @param tamY
     * @param color
     * @param rellenar
     * @return retorna una lista de todos los rectangulos
     */
    public ArrayList<Rectangle> rectangulosEsparcidos(int cantidadRectangulos, int posicionX, int posicionY, int tamX, int tamY, Color color, boolean rellenar) {
        rectangulos.clear();
        for (int i = 0; i < cantidadRectangulos; i++) {
            // Usar todo el ancho y alto de la ventana
            int numeroAleatorioX = numero.nextInt(ventana.getWindowWidth());
            int numeroAleatorioY = numero.nextInt(ventana.getWindowHeight());

            // Mantener el tamaño pequeño para las estrellas
            int alturaAleatoria = tamX + numero.nextInt(3);
            int anchoAleatorio = tamY + numero.nextInt(3);

            // Ya no necesitamos el Math.max/min aquí porque ya estamos dentro de los límites
            Rectangle rect = new Rectangle(numeroAleatorioX, numeroAleatorioY, alturaAleatoria, anchoAleatorio, color, rellenar);
            rectangulos.add(rect);
        }
        return rectangulos;
    }

    /**
     *
     * @return retorna un ArrayList de Triangulos Esparcidos
     */
    public ArrayList<Triangle> triangulosEsparcidos() {
        triangulos.clear();
        for (int i = 0; i < 10; i++) {
            int numeroAleatorioX1 = numero.nextInt(ventana.getWindowHeight());
            int numeroAleatorioY1 = numero.nextInt(ventana.getWindowWidth());
            int numeroAleatorioX2 = numero.nextInt(ventana.getWindowHeight());
            int numeroAleatorioY2 = numero.nextInt(ventana.getWindowWidth());
            int numeroAleatorioX3 = numero.nextInt(ventana.getWindowHeight());
            int numeroAleatorioY3 = numero.nextInt(ventana.getWindowWidth());
            triangulos.add(new Triangle(numeroAleatorioY1 - 10, numeroAleatorioX1 - 10,
                    numeroAleatorioY2 - 10, numeroAleatorioX2 - 10,
                    numeroAleatorioY3 - 10, numeroAleatorioX3 - 10));
        }
        return triangulos;
    }

    /**
     *
     * @return retorna un ArrayList de Triangulos Esparcidos
     */
    public ArrayList<Oval> ovalosEsparcidos() {
        ovalos.clear();
        for (int i = 0; i < 160; i++) {
            int numeroAleatorioX = numero.nextInt(ventana.getWindowWidth());
            int numeroAleatorioY = numero.nextInt(ventana.getWindowHeight());
            int alturaAleatoria = 20 + numero.nextInt(50);
            int anchoAleatorio = 20 + numero.nextInt(50);
            ovalos.add(new Oval(numeroAleatorioX, numeroAleatorioY, alturaAleatoria, anchoAleatorio));
        }
        return ovalos;
    }

    /**
     * crea ovalos esparcidos en una zona especifica
     *
     * @param cantidadOvalos cantidad de nubes que se mostrarán
     * @param alturaMaxima altura maxima donde pueden aparecer las nubes (límite
     * superior del cielo)
     * @param colorNube color que tendrán las nubes
     * @param tamMinimo tamaño minimo de las nubes
     * @param tamMaximo tamaño mxaimo de las nubes
     * @return ArrayList con los ovalos creados
     */
    public ArrayList<Oval> ovalosEsparcidos(int cantidadNubes, int alturaMaxima, Color colorNube, int tamMinimo, int tamMaximo) {
        for (int i = 0; i < cantidadNubes; i++) {
            int numeroAleatorioX = numero.nextInt(ventana.getWindowWidth());
            int numeroAleatorioY = numero.nextInt(alturaMaxima);
            int alturaAleatoria = tamMinimo + numero.nextInt(tamMaximo - tamMinimo);
            int anchoAleatorio = (int) (alturaAleatoria * (1.5 + numero.nextDouble()));
            Oval nube = new Oval(numeroAleatorioX, numeroAleatorioY, anchoAleatorio, alturaAleatoria, colorNube, true);
            ovalos.add(nube);
        }
        return ovalos;
    }

    /**
     * Agrega las figuras en la ventana
     */
    public void mostrarFiguras() {
        for (Oval n : ovalos) {
            n.addTo(ventana);
        }
        for (Rectangle m : rectangulos) {
            m.addTo(ventana);
        }
        for (Triangle m : triangulos) {
            m.addTo(ventana);
        }
    }

    /**
     * Inicia movimientos en las Figuras 
     */
    public void iniciarVibracion() {

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                vibrarFiguras();
            }
        }, 0, 100);
    }

    /**
     * Mueve las figuras de izquierda a derecha y de arriba a abajo para simular una vibracion en la figura
     */
    private void vibrarFiguras() {
        int rangoMovimiento = 1;

        for (Rectangle rect : rectangulos) {
            int deltaX = numero.nextInt(2 * rangoMovimiento + 1) - rangoMovimiento;
            int deltaY = numero.nextInt(2 * rangoMovimiento + 1) - rangoMovimiento;
            rect.moveBy(deltaX, deltaY);
        }

        for (Triangle tri : triangulos) {
            int deltaX = numero.nextInt(2 * rangoMovimiento + 1) - rangoMovimiento;
            int deltaY = numero.nextInt(2 * rangoMovimiento + 1) - rangoMovimiento;
            tri.moveBy(deltaX, deltaY);
        }

        for (Oval ovalo : ovalos) {
            int deltaX = numero.nextInt(2 * rangoMovimiento + 1) - rangoMovimiento;
            int deltaY = numero.nextInt(2 * rangoMovimiento + 1) - rangoMovimiento;
            ovalo.moveBy(deltaX, deltaY);
        }

        ventana.doRepaint();
    }

    /**
     * Detiene la vibreacion
     */
    public void detenerVibracion() {
        if (timer != null) {
            timer.cancel();
        }
    }

}
