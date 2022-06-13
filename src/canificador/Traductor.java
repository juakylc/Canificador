package canificador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Joaquín
 */
public class Traductor {
    protected final String lenguajeOrigen;
    protected final String lenguajeDestino;
    protected final String ruta;
    protected Map<String,String> diccionario;
    
    protected Traductor(String lenguajeOrigen, String lenguajeDestino, String ruta) {
        this.lenguajeOrigen = lenguajeOrigen;
        this.lenguajeDestino = lenguajeDestino;
        this.ruta = ruta;
        this.diccionario = new LinkedHashMap<String, String>();
    }

    public String getLenguajeOrigen() {
        return lenguajeOrigen;
    }

    public String getLenguajeDestino() {
        return lenguajeDestino;
    }

    public String getRuta() {
        return ruta;
    }

    public Map<String, String> getDiccionario() {
        return diccionario;
    }
    
    public void cargarDiccionario() {
        File ficheroLectura = new File(this.ruta);
        Scanner s;
        try {
            s = new Scanner(ficheroLectura);
            while (s.hasNextLine()) {
                String linea = s.nextLine();
                String castellano = linea.substring(0,linea.indexOf(';'));
                String cani = linea.substring(linea.indexOf(';')+1);
                this.diccionario.put(castellano,cani);
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("La ruta no es valida");
        }
    }
    
    public void salvarDiccionario() {
        File ficheroEscritura = new File(this.ruta);
        try {
            PrintWriter impresora = new PrintWriter(ficheroEscritura);
            imprimirDiccionario(impresora);
            impresora.close();
        } catch (FileNotFoundException ex) {
            System.out.println("La ruta no es valida");
        }

    }
    
    public void insertarVocablo(String espanol, String cani) {
        this.diccionario.put(espanol,cani);
    }

    public void imprimirDiccionario(PrintWriter impresora) {
        for(Map.Entry<String,String> entrada: this.diccionario.entrySet()){
            String castellano=entrada.getKey();
            String cani=entrada.getValue();
            impresora.println(castellano + ";" + cani);
        }
    }
    
    public void mostrarDiccionario() {
        for(Map.Entry<String,String> entrada: this.diccionario.entrySet()){
            String castellano=entrada.getKey();
            String cani=entrada.getValue();
            System.out.println(castellano + ";" + cani);
        }
    }
}
