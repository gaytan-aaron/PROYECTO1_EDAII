/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RadixSort;

import java.util.LinkedList;
import FileManager.FileManager;
import static FileManager.FileManager.countKeySize;
import java.util.List;

/**
 *
 * @author Dante Argüello
 */
public class RadixSortNumeros {
     
    /**
     *
     * @param nombreArchivo
     * Este método ordena las claves de un archivo,
     * especificamente los numeros de cuenta de las claves
     * 
     */
    public void Radix(String nombreArchivo){       
     
        List<String> filekeys;	                          //lista principal donde se almacenaran las claves del archivo
        FileManager archivo = new FileManager(1);         //creacion del objeto para manipulacion de archivos 
	filekeys = archivo.readKeyFile(nombreArchivo);    //Traer las claves del archivo a la ejecucucion
        int numKeys = countKeySize(nombreArchivo);        //Contar las claves
        String clave = new String();
        String temp;
        int i, j, x;
        
        //CREAMOS TODOS LOS ARCHIVOS QUE REPRESENTARAN A CADA CLAVE
        for (i = 1; i <= 6; i++) {
            for (j = 0; j <= 9; j++) {
                FileManager.createFile("./files/radixfiles/iter"+String.valueOf(i)+"dig"+String.valueOf(j)+".txt");
            }
        }
        
        System.out.println("Cantidad de claves: " + numKeys);        
        System.out.println("Los numeros de cuenta tienen 6 digitos, se harán 6 iteraciones: ");
        
        System.out.println("");
        System.out.println("CLAVES A ORDENAR: ");
        for(String a : filekeys){
            System.out.println(a);
        }
        
        //PARA CADA UNO DE LOS DIGITOS
        for(j = 1; j <= 6; j++) {            
            System.out.println("");
            System.out.println("ITERACION NUMERO " + j);         
            if(j == 6){
                System.out.println("----CLAVES ORDENADAS");
            }
            
            //PARA CADA UNO DE LOS ARCHIVOS
            for(x = 0 ; x <=9 ; x++){     
                
                //PARA CADA UNA DE LAS CLAVES
                for (i = 0; i < numKeys; i++) {     
                    temp = filekeys.get(i);
                        //COMPARA EL DIGITO SIGNIFICATIVO ACTUAL CON ALGUN CARACTER EN EL RANGO [0,9]
                        if(temp.charAt(temp.length() - j) == Integer.toString(x).charAt(0)){
                            System.out.println(temp);
                            //REALIZA LA ESCRITURA DE LA CLAVE EN SU ARCHIVO CORRESPONDIENTE PARA ESTA ITERACION
                            FileManager.writeKeyFile("./files/radixfiles/iter"+String.valueOf(j)+"dig"+String.valueOf(x)+".txt", temp, false);                        
                        }                
                }
            }
            
            //SE PREPARA LA LISTA DE CLAVES PARA LA SIGUIENTE ITERACION
            filekeys.clear();
            
            //SE EXTRAEN LAS CLAVES DE SUS RESPECTIVOS ARCHIVOS
            for(x = 0 ; x <=9 ; x++){
                if (archivo.readKeyFile("./files/radixfiles/iter"+String.valueOf(j)+"dig"+String.valueOf(x)+".txt") == null) {
                    //ARCHIVO VACIO
                } else {
                    //CLAVES ENCONTRADAS
                    filekeys.addAll(archivo.readKeyFile("./files/radixfiles/iter"+String.valueOf(j)+"dig"+String.valueOf(x)+".txt"));
                }
            }            

            //SE ESCRIBE EL RESUMEN DE EXTRACCION DE CLAVES EN UN SOLO ARCHIVO
            FileManager.createFile("./files/radixfiles/iteracion"+String.valueOf(j)+".txt");
            for (int k = -1; k < numKeys; k++) {                
                if(k == -1){
                    FileManager.writeKeyFile("./files/radixfiles/iteracion"+String.valueOf(j)+".txt", "ITERACION "+String.valueOf(j), false);    
                                if (j == 6){
                                    FileManager.writeKeyFile("./files/radixfiles/iteracion"+String.valueOf(j)+".txt", "CLAVES ORDENADAS : ", false);
                                }
                } else{
                    FileManager.writeKeyFile("./files/radixfiles/iteracion"+String.valueOf(j)+".txt", "", false);
                    FileManager.writeKeyFile("./files/radixfiles/iteracion"+String.valueOf(j)+".txt", filekeys.get(k), false);
                }            
            }               
            
        }        
        System.out.println("");
        System.out.println("El archivo con las claves a ordenar fue : "+nombreArchivo);
        System.out.println("Los archivos con las iteraciones se encuentran en " + "./files/radixfiles");
        System.out.println("NOMENCLATURA : ");
        System.out.println("Los archivos iterNUMdigNUM.txt representan a cada una de las claves en un determinado tiempo");
        System.out.println("Los archivos iteracionNUM.txt representan el resumen de una iteracion");
    }
    
}
