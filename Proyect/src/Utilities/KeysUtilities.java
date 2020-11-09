package Utilities;

import OrdenamientoInterno.QuickSortString;
import java.util.*;

/**
 *
 * @author Team4
 */
public class KeysUtilities {
    /*
    *Metodo que ordena una lista de llaves y las escribe en un archivo auxiliar.
    *@param keys Lista del bloque de llaves a ordenar.
    *@param fileName Nombre del archivo donde se van a escribir.
    */
    public static void sortBlock(List<String> keys, String fileName){
        String[] strArray = new String[keys.size()];
        strArray = keys.toArray(strArray);
        QuickSortString.a = strArray;
        QuickSortString.quickSort(0, strArray.length-1);
        QuickSortString.printArray(fileName);
    }
}
