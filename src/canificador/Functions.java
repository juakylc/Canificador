package canificador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Joaquín
 */
public class Functions {
    
    public static int leerEntero() {    
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
    
    public static String leerCadena(String str) {
        System.out.println("Introduce una palabra en " + str + ": ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String linea = reader.readLine();
            return linea;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al leer cadena.";
        } 
    }
}
