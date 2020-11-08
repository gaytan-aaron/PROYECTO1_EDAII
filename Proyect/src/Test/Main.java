package Test;

import FileManager.FileManager;
import Utilities.KeysIntercalation;
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
        String auxThree = "./files/auxThree.txt";
        List<String> keysOne;
        List<String> keysTwo;
        int n=3;
        FileManager polyphaseOne = new FileManager(n);
        FileManager polyphaseTwo = new FileManager(n);
        FileManager.createFile(auxOne);
        FileManager.createFile(auxTwo);
        FileManager.createFile(auxThree);
        int cont=0;
        
        while(polyphaseOne.pivot != null){
            cont++;
            keysOne = polyphaseOne.readBlockFile(fileName);
            if(cont%2==1)
                KeysUtilities.sortBlock(keysOne, auxOne);
            else
                KeysUtilities.sortBlock(keysOne, auxTwo);
        }
        
        polyphaseOne.pivot="initial";
        polyphaseTwo.pivot="initial";
        cont=0;
        
        while(polyphaseOne.pivot != null){
            cont++;
            keysOne = polyphaseOne.readBlockFile(auxOne);
            keysTwo = polyphaseTwo.readBlockFile(auxTwo);
            if(cont%2==1)
                KeysIntercalation.intercalation(keysOne, keysTwo, fileName);
            else
                KeysIntercalation.intercalation(keysOne, keysTwo, auxThree);
        }
    }
}
