package Utilities;

import FileManager.FileManager;
import java.util.*;

/**
 *
 * @author aaron
 */
public class KeysIntercalation {

    public static boolean firstTime;
    
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
    
    private static void printArray(String fileName, List<String> keys){
        for (String key : keys) {
            FileManager.writeKeyFile(fileName, key, firstTime);
            firstTime = false;
        }
    }
}
