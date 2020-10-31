package Test;

import static FileManager.FileManager.*;
import java.util.*;

/**
 * @author Team4
 */
public class Main {
    public static void main(String[] args) {
        String fileName = "./files/keys.txt";
        List <String> keys;
        
        keys = readKeyFile(fileName);
        
        for(String fullKey: keys){
            System.out.println("key = " + fullKey);
        }
    }
}
