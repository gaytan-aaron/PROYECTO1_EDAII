package OrdenamientoInterno;

import FileManager.FileManager;
import Utilities.StringUtilities;

/**
 *
 * @author Team4
 */
public class QuickSortString {
    
    /*
    *Arreglo de cadenas a las que se le va a aplicar el ordenamiento por
    *Quick Sort.
    */
    public static String[] a;
    
    /*
    *Método que realiza el ordenamiento por quickSort.
    *@param start Indica el inicio de la parte del arreglo a ordenar.
    *@para end Indica el final de la parte del arreglo a ordenar.
    */
    public static void quickSort(int start, int end){
        int i = start;
        int j = end;

        if (j - i >= 1)
        {
            String pivot = StringUtilities.stringLastName(a[i]);

            while (j > i)
            {
                
                while (StringUtilities.stringLastName(a[i]).compareTo(pivot) <= 0 && i < end && j > i){
                    i++;
                }
                
                while (StringUtilities.stringLastName(a[j]).compareTo(pivot) >= 0 && j > start && j >= i){
                    j--;
                }
                
                if (j > i)
                    swap(i, j);
            }
            
            swap(start, j);
            
            quickSort(start, j - 1);
            
            quickSort(j + 1, end);
        }
    }
    
    /*
    *Intercambia dos elementos obtenidos por los parametros.
    *@param i Elemento 1 a intercambiar.
    *@param j Elemento 2 a intercambiar.
    */
    private static void swap(int i, int j)
    {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
    }
    
    /*
    *Método que imprime los elementos ordenados en un archivo auxiliar.
    *@param fileName Nombre del archivo donde se van a escribir las claves.
    */
    public static void printArray(String fileName){
        for(String s: a){
            FileManager.writeKeyFile(fileName, s, false);
            FileManager.writeKeyFile("./files/fileIt.txt", s, false);
        }
    }
}
