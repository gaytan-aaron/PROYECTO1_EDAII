
package proyect;

import java.util.*;


/**
 * @author Team4
 */
public class Proyect {
    public static void main(String[] args) {
        String fileName = "./files/keys.txt";
        List <String> keys;
 
        
        keys = FileManager.readKeyFile(fileName);
        
        
        for(String fullKey: keys){
            System.out.println("key = " + fullKey);
        }
        
    }
}
