package Test;

import FileManager.FileManager;
import Utilities.KeysUtilities;
import java.util.*;

/**
 * @author Team4
 */
public class Main {

    public static void main(String[] args) {
        String fileName = "./files/keys.txt";
        String auxOne = "./files/auxOne.txt";
        String auxTwo = "./files/auxTwo.txt";
        List<String> keys;
        FileManager polyphase = new FileManager(3);
        FileManager.createFile(auxOne);
        FileManager.createFile(auxTwo);
        int cont=0;
        
        while(polyphase.pivot != null){
            cont++;
            keys = polyphase.readBlockFile(fileName);
            if(cont%2==1)
                KeysUtilities.sortBlock(keys, auxOne);
            else
                KeysUtilities.sortBlock(keys, auxTwo);
        }

    }
}
