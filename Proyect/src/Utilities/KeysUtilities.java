package Utilities;

import OrdenamientoInterno.QuickSortString;
import java.util.*;

/**
 *
 * @author aaron
 */
public class KeysUtilities {
    public static void sortBlock(List<String> keys, String fileName){
        String[] strArray = new String[keys.size()];
        strArray = keys.toArray(strArray);
        QuickSortString.a = strArray;
        QuickSortString.quickSort(0, strArray.length-1);
        QuickSortString.printArray(fileName);
    }
}
