package canificador;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joaquín
 */
public class Canificador {

    public static void main(String[] args) {
        String ruta = "vocablos.txt";
        TraductorCastellanoCani t = new TraductorCastellanoCani(ruta);
        t.cargarDiccionario();
        int n;
        System.out.println("Bienvenido al traductor Castellano-Cani");
        do {
            System.out.println("--------------------------------------------");
            menu();
            n = Functions.leerEntero();
            System.out.println("--------------------------------------------");
            menu(n,t);
        } while (n!=3);        
    }
    
    public static void menu() {
        System.out.println("0. Mostrar Diccionario Castellano-Cani");
        System.out.println("1. Traducir");
        System.out.println("2. Insertar");
        System.out.println("3. Guardar y Salir");
    }
    
    public static void menu(int n, TraductorCastellanoCani t) {
        switch(n) {
            case 0: t.mostrarDiccionario();break;
            case 1: submenu(t);break;
            case 2: t.insertarVocablo(Functions.leerCadena("castellano"), Functions.leerCadena("cani"));break;
            case 3: t.salvarDiccionario();break;
            default: System.out.println("Error, el numero seleccionado no se encuentra entre 0 y 3");
                     System.out.println("");
                     System.out.println("Por favor, seleccione un numero de entre los siguientes: "); break;
        }
    }
    
    public static void submenu(TraductorCastellanoCani t) {
        int m;
        do {
            System.out.println("1. Castellano -> Cani");
            System.out.println("2. Cani - > Castellano");
            System.out.println("3. Volver al menu inicial");
            m = Functions.leerEntero();
            System.out.println("--------------------------------------------");
            switch (m) {
                case 1: System.out.println(t.translateToCani(Functions.leerCadena("castellano"))); break;
                case 2: System.out.println(t.reverseTranslate(Functions.leerCadena("cani"))); break;
                case 3: System.out.println("Por favor, seleccione un numero de entre los siguientes: "); break;
                default: System.out.println("Error, el numero seleccionado no se encuentra entre 1 y 3");
                         System.out.println("");
                         System.out.println("Por favor, seleccione un numero de entre los siguientes: "); break;
            } 
        } while (m>3 || m<1);
    }
}
