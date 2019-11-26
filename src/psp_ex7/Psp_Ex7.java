/*
Programa que simule un buzón de correo (recurso compartido), de xeito que se
poida leer unha mensaje ou envialo. O buzón soamente pode almacear unha
mensaxe, de xeito que para poder escribir débese atopar baleiro e para poder leer
debe de estar cheo. Crear varios fíos lectores e escritores que manexen o buzón
de xeito sincronizado.
 */
package psp_ex7;

public class Psp_Ex7 {

    public static void main(String[] args) {

        Buzon objB = new Buzon();

        Escritor e1 = new Escritor("Juan", "Esto es un texto de JUAN", objB);
        Escritor e2 = new Escritor("Mario", "Esto es un texto de Mario", objB);
        Escritor e3 = new Escritor("Pepe", "Esto es un texto de Pepe", objB);
        Escritor e4 = new Escritor("Ter", "Esto es un texto de Ter", objB);

        Lector l1 = new Lector("Nana", objB);
        Lector l2 = new Lector("Mari", objB);
        Lector l3 = new Lector("Jose", objB);
        Lector l4 = new Lector("Ricardo", objB);
        
        e1.start();
        e2.start();
        e3.start();
        e4.start();
        l1.start();
        l2.start();
        l3.start();
        l4.start();

    }

}
