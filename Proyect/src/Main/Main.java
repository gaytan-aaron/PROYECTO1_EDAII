package Main;

import FileManager.FileManager;
import Utilities.KeysIntercalation;
import Utilities.KeysUtilities;
import java.util.*;
import Mezcla.*;
import java.io.*;

/**
 * @author Team4
 */
public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int opcion; //opcion para el menu
        boolean bandera = true; //variable booleana que dictaminara el cierre o la repeticion del ciclo del menu
        System.out.println(" ");    
        System.out.println("Bienvenido al programa");    
        System.out.println(" ");   
        String nombreArchivo;
        Main principal = new Main();

        do{
            File carpeta = new File("./files"); //leerá los archivos que hay disponibles para ordenar
            String[] listado = carpeta.list();
            
            System.out.println("1) Ingresar el nombre del archivo de entrada");   
            System.out.println("2) Salir: ");
            System.out.print("Su opci\u00f3n es: "); 
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    if (listado == null || listado.length == 0) {
                        System.out.println(" ");
                        System.out.println("No hay elementos dentro de la carpeta actual");
                        System.out.println(" ");
                        break;
                    }
                    else {
                        System.out.println(" ");   
                        System.out.println("Los archivos para poder ordenar son los siguientes: ");  
                        System.out.println(" ");
                        for (int i=0; i< listado.length; i++) { //se mostrará la lista de archivos para ordenar
                            System.out.println("Archivo " + (1+i) + ": " + listado[i]);
                        }
                        System.out.println(" "); 
                        System.out.println("Ingrese el nombre del archivo en el siguiente formato: ./files/nombreArchivo.txt"); 
                        System.out.print("El nombre del archivo es: ");
                        nombreArchivo = sc1.nextLine();
                        System.out.println(" "); 

                        principal.algoritmoDeOrdenamiento(nombreArchivo);  
                        break;  

                    }
                case 2:
                    System.out.println("Gracias por usar el programa");
                    bandera = false;    //se cambia la bandera para salir del ciclo
                    break;
                default:
                    System.out.println("Opci\u00f3n no v\u00e1lida");
                    break;
            }
        }while(bandera);

    }



    public void algoritmoDeOrdenamiento(String fileName){

        Scanner sd = new Scanner(System.in);
        Scanner xd = new Scanner(System.in);

        int op; //opcion para el menu
        boolean b = true;   
        System.out.println(" ");    
        do{
            System.out.println("Escoja el algoritmo de ordenamiento a usar");   
            System.out.println("1) Polifase ");
            System.out.println("2) Mezcla equilibrada ");
            System.out.println("3) Radix  ");
            System.out.println("4) Salir ");
            System.out.print("Su opcion es: "); //agregue una indicacion en pantalla
            op = sd.nextInt();
            switch(op){
                case 1:
                    System.out.println(" ");
                    System.out.println("Aqui va polifasñ2e");
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Ordenamiento por Mezcla Equilibrada");
                    System.out.println(" ");
                    Mezcla.mezclaEquilibrada(fileName);
                    System.out.println(" ");
                    System.out.println("Se ha realizado el ordenamiento");
                    System.out.println("Los archivos auxiliares con iteraciones se muestran en: ./files/orden");
                    System.out.println("El archivo original ordenado se encuentran en: ./files");
                    System.out.println(" ");
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("Aqui va Radix ");
                    System.out.println(" ");
                    break;
                case 4:
                     b=false;    //se cambia la bandera para salir del ciclo
                    break;
                default:
                    System.out.println("Opci\u00f3n no v\u00e1lida");
                    break;
            }
        }while(b);
    }



}
