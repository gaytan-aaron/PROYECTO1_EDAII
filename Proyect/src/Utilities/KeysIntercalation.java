package Utilities;

import FileManager.FileManager;
import java.util.*;

/**
 *
 * @author Team4
 */
public class KeysIntercalation {

    public static boolean firstTime; //Indica si es la primera intercalacion en la iteracion, esto sirve para reescribir un archivo.
    
    /*
    *Metodo que realiza la intercalacion de dos listas de llaves, al finalizar escribe una lista con todas las
    *llaves ordenadas en un archivo auxiliar.
    *@param keyOne Lista de las llaves a intercalar.
    *@param keyTwo Lista de las llaves con las que se van a intercalar.
    *@param fileName Nombre del archivo donde se van a escribir las llaves intercaladas.
    */
    public static void intercalation(List<String> keyOne, List<String> keyTwo, String fileName){
        List<String> keys = new LinkedList<>();
        if(keyTwo != null){
            while(!keyOne.isEmpty() && !keyTwo.isEmpty()){
                if(StringUtilities.stringLastName(keyOne.get(0)).compareTo(StringUtilities.stringLastName(keyTwo.get(0)))<0){
                    keys.add(keyOne.remove(0));
                }
                else
                    keys.add(keyTwo.remove(0));
            }
        }
        if(!keyOne.isEmpty()){
            while(!keyOne.isEmpty())
                keys.add(keyOne.remove(0));
        }
        else{
            while(!keyTwo.isEmpty())
                keys.add(keyTwo.remove(0));
        }
        printArray(fileName, keys);
    }
    
    /*
    *Metodo encargado de escribir una lista de llaves en un archivo auxiliar.
    *@param fileName Nombre del archivo donde se van a escribir las llaves.
    *@param keys Lista de llaves ordenadas a escribir en el archivo auxiliar.
    */
    private static void printArray(String fileName, List<String> keys){
        for (String key : keys) {
            FileManager.writeKeyFile(fileName, key, firstTime);
            FileManager.writeKeyFile("./files/fileIt.txt", key, false);
            firstTime = false;
        }
    }
}
