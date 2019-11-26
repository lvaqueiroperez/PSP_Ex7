package psp_ex7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lector extends Thread {

    private Buzon objB;

    public Lector(String nombre, Buzon objB) {

        super(nombre);

        this.objB = objB;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            objB.leer(getName());
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
