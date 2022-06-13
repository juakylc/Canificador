package canificador;

import java.util.Map;

/**
 *
 * @author Joaquín
 */
public class TraductorCastellanoCani extends Traductor implements TraductorInverso{
    
    public TraductorCastellanoCani(String ruta) {
        super("Castellano", "Cani", ruta);
    }
    
    public String translateToCani(String castellano) {
        System.out.println("--------------------------------------------");
        String cani = this.diccionario.get(castellano);
        if (cani == null) {
            return "Error, no existe ese registro en el diccionario";
        } else {
            return cani;
        }
    }
    
    public String reverseTranslate(String cani) {
        System.out.println("--------------------------------------------");
        String castellano = buscar(cani);
        if (castellano == null) {
            return "Error, no existe ese registro en el diccionario";
        } else {
            return castellano;
        }
    }
    
    public String buscar(String palabra) {
        String res = null;
        for(Map.Entry<String,String> entrada: this.diccionario.entrySet()){
            if (entrada.getValue().equals(palabra)) {
                res = entrada.getKey(); break;
            }
        }
        return res;
    }
}
