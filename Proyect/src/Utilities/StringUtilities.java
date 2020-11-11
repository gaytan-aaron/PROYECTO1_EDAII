package Utilities;

/**
 *
 * @author aaron
 */
public class StringUtilities {
    public static int opt;
    
    public static String stringLastName(String initial){
        int position;
        int positionOne;
        String ult = "0";
        switch(opt){
            case 1:
                position = initial.indexOf(','); 
                ult = initial.substring(0, position);
                break;
            case 2:
                positionOne = initial.indexOf(',');
                position = initial.indexOf(',', positionOne+1);
                ult = initial.substring(positionOne, position);
                break;
            case 3:
                positionOne = initial.indexOf(',');
                position = initial.indexOf(',', positionOne+1);
                ult = initial.substring(position,initial.length()-1);
                break;
            default:
                System.out.println("Va a fallar");
        }
        return ult;
    }
}
