package psp_ex7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Escritor extends Thread {

    private String texto;
    private Buzon objB;

    public Escritor(String nombre, String texto, Buzon objB) {

        super(nombre);
        this.texto = texto;
        this.objB = objB;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            try {
                objB.escribir(texto, getName());
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
