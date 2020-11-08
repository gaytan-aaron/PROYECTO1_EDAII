package Utilities;

/**
 *
 * @author aaron
 */
public class StringUtilities {
    public static String stringLastName(String initial){
        int position;
        position = initial.indexOf(',');
        String ult;
        ult = initial.substring(0, position);
        return ult;
    }
}
