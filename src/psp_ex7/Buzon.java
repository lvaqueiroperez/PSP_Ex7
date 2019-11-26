package psp_ex7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Buzon {

    //recurso compartido 
    private String msg;
    //boolean semáforo para comprobar cuando el buzón está vacío o lleno
    //(también podríamos usar como comprobación msg en vez de esta variable)
    private Boolean vacio = true;

    public synchronized void escribir(String texto, String nombre) {

        while (!vacio) {

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buzon.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        vacio = false;

        msg = texto;

        System.out.println("MENSAJE ESCRITO POR: " + nombre);

        //una vez escrito el mensaje, hasta que no sea leído no podremos escribir otro
        notifyAll();
    }

    public synchronized void leer(String nombre) {

        while (vacio) {

            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Buzon.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println(nombre + " LEE EL MENSAJE: " + msg);

        //una vez leído el mensaje, indicamos que ya se puede volver a escribir
        //y avisamos
        vacio = true;

        notifyAll();

    }

}
