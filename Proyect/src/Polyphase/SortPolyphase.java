package Polyphase;

import FileManager.FileManager;
import Utilities.KeysIntercalation;
import Utilities.KeysUtilities;
import Utilities.StringUtilities;
import java.util.List;

/**
 *
 * @author Team4
 */
public class SortPolyphase {
    
    /*
    *Realiza el proceso de ordenamiento externo por Polifase.
    *Es necesario haber creado el archivo de llaves a ordenar.
    */
    public static void sortPoly(String fN, int opc) {
        StringUtilities.opt = opc;
        String fileName = fN;
        String auxOne = "./files/auxOne.txt";
        String auxTwo = "./files/auxTwo.txt";
        String auxThree = "./files/auxThree.txt";
        String fileIt = "./files/fileIt.txt";
        List<String> keysOne;
        List<String> keysTwo;
        int keyNumber = FileManager.countKeySize(fileName);
        int n = 3;
        int cont = 0;
        int externCont = 0;
        int contInter;
        FileManager polyphaseOne = new FileManager(n);
        FileManager polyphaseTwo = new FileManager(n);
        FileManager.createFile(auxOne);
        FileManager.createFile(auxTwo);
        FileManager.createFile(auxThree);
        FileManager.createFile(fileIt);

        while (polyphaseOne.pivot != null) {
            cont++;
            keysOne = polyphaseOne.readBlockFile(fileName);
            if (cont % 2 == 1) {
                KeysUtilities.sortBlock(keysOne, auxOne);
            } else {
                KeysUtilities.sortBlock(keysOne, auxTwo);
            }
        }

        FileManager.writeKeyFile(fileIt, "******", false);

        while (n <= keyNumber / 2) {
            externCont++;
            polyphaseOne.pivot = "initial";
            polyphaseOne.n = n;
            polyphaseTwo.pivot = "initial";
            polyphaseTwo.n = n;
            cont = 0;
            contInter = 0;

            while (polyphaseOne.pivot != null) {
                if (contInter <= 1) {
                    KeysIntercalation.firstTime = true;
                    contInter++;
                }
                cont++;
                if (externCont % 2 == 1) {
                    keysOne = polyphaseOne.readBlockFile(auxOne);
                    if (polyphaseTwo.pivot != null) {
                        keysTwo = polyphaseTwo.readBlockFile(auxTwo);
                    } else {
                        keysTwo = null;
                    }

                    if (cont % 2 == 1) {
                        KeysIntercalation.intercalation(keysOne, keysTwo, fileName);
                    } else {
                        KeysIntercalation.intercalation(keysOne, keysTwo, auxThree);
                    }
                } else {
                    keysOne = polyphaseOne.readBlockFile(fileName);
                    if (polyphaseTwo.pivot != null) {
                        keysTwo = polyphaseTwo.readBlockFile(auxThree);
                    } else {
                        keysTwo = null;
                    }

                    if (cont % 2 == 1) {
                        KeysIntercalation.intercalation(keysOne, keysTwo, auxOne);
                    } else {
                        KeysIntercalation.intercalation(keysOne, keysTwo, auxTwo);
                    }
                }
            }

            FileManager.writeKeyFile(fileIt, "******", false);

            n = n * 2;
        }

        if (externCont % 2 == 0) {
            if (keyNumber > FileManager.countKeySize(auxOne)) {
                keysOne = polyphaseOne.readKeyFile(auxOne);
                keysTwo = polyphaseTwo.readKeyFile(auxTwo);
                KeysIntercalation.firstTime = true;
                KeysIntercalation.intercalation(keysOne, keysTwo, fileName);
                System.out.println("Tu archivo ordenado esta en " + fileName);
            } else {
                System.out.println("Tu archivo ordenado esta ahora en " + auxOne);
                System.out.println("¡Ahora tu archivo que contiene tus claves ha cambiado! por favor sal y selecciona el archivo: " + auxOne);
            }
        } else {
            if (keyNumber > FileManager.countKeySize(fileName)) {
                keysOne = polyphaseOne.readKeyFile(fileName);
                keysTwo = polyphaseTwo.readKeyFile(auxThree);
                KeysIntercalation.firstTime = true;
                KeysIntercalation.intercalation(keysOne, keysTwo, auxOne);
                System.out.println("Tu archivo ordenado esta en " + auxOne);
                System.out.println("¡Ahora tu archivo que contiene tus claves ha cambiado! por favor sal y selecciona el archivo: " + auxOne);
            } else {
                System.out.println("Tu archivo ordenado esta en " + fileName);
            }
        }
    }
}
