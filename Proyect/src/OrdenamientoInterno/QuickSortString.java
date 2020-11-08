package OrdenamientoInterno;

import FileManager.FileManager;
import Utilities.StringUtilities;

/**
 *
 * @author aaron
 */
public class QuickSortString {
    
    public static String[] a;
    
    public static void quickSort(int start, int end){
        // index for the "left-to-right scan"
        int i = start;
        // index for the "right-to-left scan"
        int j = end;

        // only examine arrays of 2 or more elements.
        if (j - i >= 1)
        {
            // The pivot point of the sort method is arbitrarily set to the first element int the array.
            String pivot = StringUtilities.stringLastName(a[i]);
            // only scan between the two indexes, until they meet.
            while (j > i)
            {
                // from the left, if the current element is lexicographically less than the (original)
                // first element in the String array, move on. Stop advancing the counter when we reach
                // the right or an element that is lexicographically greater than the pivot String.
                while (StringUtilities.stringLastName(a[i]).compareTo(pivot) <= 0 && i < end && j > i){
                    i++;
                }
                // from the right, if the current element is lexicographically greater than the (original)
                // first element in the String array, move on. Stop advancing the counter when we reach
                // the left or an element that is lexicographically less than the pivot String.
                while (StringUtilities.stringLastName(a[j]).compareTo(pivot) >= 0 && j > start && j >= i){
                    j--;
                }
                // check the two elements in the center, the last comparison before the scans cross.
                if (j > i)
                    swap(i, j);
            }
            // At this point, the two scans have crossed each other in the center of the array and stop.
            // The left partition and right partition contain the right groups of numbers but are not
            // sorted themselves. The following recursive code sorts the left and right partitions.

            // Swap the pivot point with the last element of the left partition.
            swap(start, j);
            // sort left partition
            quickSort(start, j - 1);
            // sort right partition
            quickSort(j + 1, end);
        }
    }
    /**
     * This method facilitates the quickSort method's need to swap two elements, Towers of Hanoi style.
     */
    private static void swap(int i, int j)
    {
    String temp = a[i];
    a[i] = a[j];
    a[j] = temp;
    }
    
    public static void printArray(String fileName){
        for(String s: a){
            FileManager.writeKeyFile(fileName, s);
        }
    }
}
