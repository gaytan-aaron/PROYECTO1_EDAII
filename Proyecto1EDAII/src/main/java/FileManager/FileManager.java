package FileManager;

import java.io.*;
import java.util.*;

/**
 * @author Team4
 */
public class FileManager {
    
    public static List <String> readKeyFile(String fileName){
        File keyFile = new File(fileName);
        List <String> keys = new LinkedList<>(); 
        try {
            BufferedReader input;
            input = new BufferedReader(new FileReader(keyFile));
            String reading = input.readLine();
            while(reading != null){
                System.out.println("Clave leida: " + reading);
                keys.add(reading);
                reading = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return keys;
    }
}
