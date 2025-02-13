package itsover;

import java.io.File;
import uwcse.io.Sound;
/**
 * 
 * @author Jona
 */
public class Musica {

    private Sound song;
    /**
     * 
     * @param nombre el nombre de la musica debe tener extension ".wav" y debe estar en el mismo directorio
     */
    public Musica(String nombre) {
        song = new Sound(getClass()
                         .getClassLoader()
                         .getResource("musica" + File.separator + nombre));
    }
    
    /**
     * 
     */
    
    public void reproducir() {
        song.play();
    }
    
    /**
     * 
     */
    public void parar() {
        song.stop();
    }

}
