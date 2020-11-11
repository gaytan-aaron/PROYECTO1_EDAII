package Main;

import FileManager.FileManager;
import Utilities.KeysIntercalation;
import Utilities.KeysUtilities;
import java.util.*;
import Mezcla.*;
import RadixSort.*;
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
        String nombreArchivo;
        Main principal = new Main();

        do{
            System.out.println(" ");  
            File carpeta = new File("./files"); //leerá los archivos que hay disponibles para ordenar
            String[] listado = carpeta.list();
            System.out.println("Archivo"); 
            System.out.println("1) Ingresar el nombre del archivo de entrada");   
            System.out.println("2) Salir: ");
            System.out.print("Su opci\u00f3n es: "); 
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    if (listado == null || listado.length == 0) {
                        System.out.println(" ");
                        System.out.println("No hay elementos dentro de la carpeta actual");
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

                        principal.algoritmoDeOrdenamiento(nombreArchivo);  
                        break;  

                    }
                case 2:
                    System.out.println(" ");   
                    System.out.println("Gracias por usar el programa");
                    bandera = false;    //se cambia la bandera para salir del ciclo
                    break;
                default:
                    System.out.println(" ");   
                    System.out.println("Opci\u00f3n no v\u00e1lida");
                    break;
            }
        }while(bandera);

    }



    public void algoritmoDeOrdenamiento(String fileName){

        Scanner sd = new Scanner(System.in);
        Main principal = new Main();

        int op; //opcion para el menu
        boolean b = true;   
         
        do{
            System.out.println(" "); 
            System.out.println("Algoritmo de ordenamiento");   
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
                    System.out.println("Aqui va polifase");
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Ordenamiento por Mezcla Equilibrada");
                    principal.menuMezcla(fileName);
                    break;
                case 3:
                    System.out.println(" ");
                    principal.menuRadix(fileName);
                    break;
                case 4:
                     b=false;    //se cambia la bandera para salir del ciclo
                    break;
                default:
                    System.out.println(" "); 
                    System.out.println("Opci\u00f3n no v\u00e1lida");
                    break;
            }
        }while(b);
    }



    public void menuMezcla(String nombreDelArchivo){

        Scanner xd = new Scanner(System.in);
        Main principal = new Main();

        int option; //opcion para el menu
        boolean flag = true;      
        do{
            System.out.println(" "); 
            System.out.println("Mezcla equilibrada"); 
            System.out.println("Seleccione el criterio de ordenamiento");   
            System.out.println("1) Nombres ");
            System.out.println("2) Apellidos ");
            System.out.println("3) Numero de cuenta  ");
            System.out.println("4) Salir ");
            System.out.print("Su opcion es: "); //agregue una indicacion en pantalla
            option = xd.nextInt();
            switch(option){
                case 1:
                    Mezcla.mezclaEquilibradaNombre(nombreDelArchivo);
                    System.out.println(" ");
                    System.out.println("Se ha realizado el ordenamiento por nombre");
                    System.out.println("Los archivos auxiliares con iteraciones se muestran en: ./files/orden");
                    System.out.println("El archivo original ordenado se encuentran en: ./files");
                    
                    break;
                case 2:
                    Mezcla.mezclaEquilibradaApellido(nombreDelArchivo);
                    System.out.println(" ");
                    System.out.println("Se ha realizado el ordenamiento por apellidos");
                    System.out.println("Los archivos auxiliares con iteraciones se muestran en: ./files/orden");
                    System.out.println("El archivo original ordenado se encuentran en: ./files");
                    
                    break;
                case 3:
                    Mezcla.mezclaEquilibradaNumero(nombreDelArchivo);
                    System.out.println(" ");
                    System.out.println("Se ha realizado el ordenamiento por numero de cuenta");
                    System.out.println("Los archivos auxiliares con iteraciones se muestran en: ./files/orden");
                    System.out.println("El archivo original ordenado se encuentran en: ./files");
                    
                    break;
                case 4:
                     flag=false;    //se cambia la bandera para salir del ciclo
                    break;
                default:
                    System.out.println(" ");
                    System.out.println("Opci\u00f3n no v\u00e1lida");
                    break;
            }
        }while(flag);
    }
    
    public void menuRadix(String nombreDelArchivo){
        System.out.println("");
        System.out.println("Bienvenido a RadixSort");
        System.out.println("Se hará un ordenamiento de los numeros de cuenta");
        RadixSortNumeros radix = new RadixSortNumeros();
        radix.Radix(nombreDelArchivo);
    }



}
