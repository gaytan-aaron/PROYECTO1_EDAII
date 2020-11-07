package Test;

import FileManager.FileManager;
import java.util.*;

/**
 * @author Team4
 */
public class Main {

    public static void main(String[] args) {
        String fileName = "./files/keys.txt";
        List<String> keys;
        FileManager polyphase = new FileManager(5);
        
        while(polyphase.pivot != null){
            keys = polyphase.readBlockFile(fileName);
        }

    }
}
