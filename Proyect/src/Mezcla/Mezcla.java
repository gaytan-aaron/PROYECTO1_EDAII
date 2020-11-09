package Mezcla;

import java.util.*;
import FileManager.FileManager;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mezcla{

	
	public static void mezclaEquilibrada(String nombreArchivo){    //recibira la direccion del archivo en cadena
            
        String aux1 = "./files/orden/aux1.txt"; //direcciones de los archivos auxiliares
        String aux2 = "./files/orden/aux2.txt";
        String orden = "./files/orden/orden.txt";
                
        FileManager.createFile(aux1);   //creacion de los 2 archivos auxiliares
        FileManager.createFile(aux2);
        FileManager.createFile(orden);	//creacion de un archivo igual al original para mostrar las iteraciones

        File archivo = new File(nombreArchivo); 
                
        List<String> arr;	//lista principal donde se almacenaran las claves del archivo

		FileManager leer = new FileManager(1);  //creacion del objeto para manipulacion de archivos 

		arr = leer.readKeyFile(nombreArchivo);    //en la lista se almacenan las claves del archivo


		BufferedWriter bw = null;
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));	//manejo de bufferWriter para escribir en los archivos...
            														//...agregando al original y sobreescribiendo

                    bw.write("");	//sobreescribir todo el aechivo original

        FileManager.writeKeyFile(aux1, " ", false);		//esto permite escribir en el archivo auxiliar 1
		FileManager.writeKeyFile(aux1, "Primer archivo auxiliar", false);
		FileManager.writeKeyFile(aux1, " ", false);

		FileManager.writeKeyFile(aux2, " ", false);		//esto permite escribir en el archivo auxiliar 2
		FileManager.writeKeyFile(aux2, "Segundo archivo auxiliar", false);
		FileManager.writeKeyFile(aux2, " ", false);
             
		int inicio = 0;
		int fin = 1;
		int l = 1;

		int k = 0;
		int m = 0; 
		int h = 0;
		int cont = 0;

		int inicioAux = 0;
		int finAux = 0;

		boolean ordenado = false;
		boolean bandera = true;		//este booleano hará que se ingresen elementos a la lista 1...
									//... y luego a la 2 de forma intercalada.
                                                                        
		List<String> arr1 = new LinkedList<>(); //listas auxiliares para el tratamiento de las claves
		List<String> arr2 = new LinkedList<>();

		int tamanoListaOriginal = arr.size();   //variable auxiliar que sabrá el número de elementos dentro del archivo/lista

		do{

			
			bandera = true;

			cont++;

			FileManager.writeKeyFile(orden, " ", false);		//esto permite escribir en los archivos aux
            FileManager.writeKeyFile(orden, " ", false);
			FileManager.writeKeyFile(orden, cont + "a iteracion de mezcla natural", false);

			FileManager.writeKeyFile(aux1, " ", false);		//esto permite escribir en los archivos aux
			FileManager.writeKeyFile(aux1, cont + "a iteracion de mezcla natural", false);
			FileManager.writeKeyFile(aux1, " ", false);

			FileManager.writeKeyFile(aux2, " ", false);		//esto permite escribir en los archivos aux
			FileManager.writeKeyFile(aux2, cont + "a iteracion de mezcla natural", false);
			FileManager.writeKeyFile(aux2, " ", false);	
			
		
			//este proceso se encargará de ver qué elementos estan ordenados de forma natural y...
			//...los ingresara de forma intercalada en cada lista auxiliar, todo en bloques.

			while( arr.size() != 0){	//mientras la lita original no este vacia.
				inicio = 0;		//se inicializan siempre, porque al eliminar datos...
								//... de la lista, todos los elementos se recorren a la izquierda.
				fin = 1;
				l = 1;
				if(arr.size() > 1){	//si hay mas de un elemento
					while( (arr.size() > l) && ((arr.get(l-1).compareTo(arr.get(l))) <= 0)){	//compara al elemento...
																						//...actual con el anterior...
																					//...siempre y cuando nos encontremos...
																				//...en indices validos.
						fin+=1;	// fin al final dirá el numero de elementos que entreran en la lista aux 1 o 2.
						l+=1;

					}
					if(fin == tamanoListaOriginal){	//comprueba si ya no se puede crear un bloque de mayor tamaño,...
													//...lo cual indicaría el final del ordenamiento
							ordenado = true;
							break;
					}
				}


				
				if(bandera){	//la bandera dira a que lista imprimirse.
					if(arr.size() == 1){	//
						FileManager.writeKeyFile(aux1, arr.get(0), false);	
						FileManager.writeKeyFile(aux1, " ", false);
						arr1.add(arr.remove(0));	//si solo se detectó un elemento en orden, ...
						inicio++;							//... se agrega a la lista aux y se elimina de la original.
					}else{
						while((inicio < fin) && (arr.size()>=1)){						//esto permitira que se recorran los elementos...
							FileManager.writeKeyFile(aux1, arr.get(0), false);		//...de forma natural y...
																						//...se ingresen a la lista aux. 
							arr1.add(arr.remove(0));	//se estrae el primer elemento de la lista original...
														//...pues siempre se recorren a la izquierda.
							inicio++;
						}
						FileManager.writeKeyFile(aux1, " ", false);	
					}
				}


				
				if(!bandera){
					if(arr.size()==1){
							FileManager.writeKeyFile(aux2, arr.get(0), false);	
							FileManager.writeKeyFile(aux2, " ", false);
							arr2.add(arr.remove(0));
							inicio++;
					}else{
						while((inicio < fin) && (arr.size()>=1)){
							FileManager.writeKeyFile(aux2, arr.get(0), false);	
							arr2.add(arr.remove(0));
							inicio+=1;
						}
						FileManager.writeKeyFile(aux2, " ", false);	
					}
				}
		 
				bandera = !bandera;		//esta bandera se intercalara para ingresar...
										//...los elementos ya sea en la lista aux 1 o 2...
										//...en cada iteracion
				
			}
			

			//ahora se mezclaran las particiones y se ordenaran en la lista original...
			//...por bloques

			inicio = 0;
			
			while( (arr1.size() != 0) | (arr2.size() != 0) ){	//mientras una lista u otra no esté vacía

				if(ordenado == true){	
					break;		//si ya está ordenada la lista, se termina la ejecución de esta parte
				}

				k = 1;
				m = 1;
				
				inicioAux = inicio;

				while( (arr1.size() > k) && (arr1.get(k-1).compareTo(arr1.get(k)) <= 0 ) ){
					k++;	//contará el numero de elementos que estan ordenados en orden natural...
							//...en la lista aux 1.
				}

				while( (arr2.size() > m) && (arr2.get(m-1).compareTo(arr2.get(m)) <= 0 ) ){
					m++;	//contará el numero de elementos que estan ordenados en orden natural...
							//...en la lista aux 2.
				}



				if(arr1.size() != 0){
					if(k == 1){	//
						arr.add(arr1.remove(0));	//si solo se detectó un elemento en orden, ...
						inicio++;							//... se agrega a la lista original y se elimina de la aux.
					}else{
						while((inicio < (k + inicioAux)) && (arr1.size()>=1)){	//esto permitira que se recorran los elementos...
																//...de forma natural y...
																//...se ingresen a la lista original. 
							arr.add(arr1.remove(0));	//se estrae el primer elemento de la lista aux...
														//...pues siempre se recorren los elementos a la izquierda.
							inicio++;
						}
					}
				}



				if(arr2.size() != 0){
					if(m==1){
							arr.add(arr2.remove(0));
							inicio++;
					}else{
						while((inicio < (m + k + inicioAux)) && (arr2.size()>=1)){	//se toma en cuenta el inicioAux en cada iteracion...
															//...y así siempre se tendrá un indice de las particiones
							arr.add(arr2.remove(0));
							inicio+=1;
						}
					}
				}

				finAux = arr.size();

					//ordenamiento de cada particion

				//este metodo se encarga de ordenar cada particion dentro de la lista original, después de haber...
				//...unido las particiones de cada lista auxiliar

				for(int i = inicioAux + 1; i < arr.size(); i++){	
					StringBuilder temp = new StringBuilder(arr.get(i));	//de string a stringbuilder. Se usó...
									//...stringbuilder por su mutabilidad ya que fue necesaria esta característica...
								//en esta seccion de una cadena auxiliar que cambia a lo largo de la ejecución
					h = i - 1;
					while((h>=(inicioAux)) && (arr.get(h).compareTo(temp.toString()) >= 0)){	//stringbuilder a string
						arr.set(h+1,arr.get(h));
						h--;
					}
					arr.set(h+1,temp.toString());	//stringbuilder a string
				}


			}
                        
          
          
			//espaciado en el archivo de las iteraciones
			FileManager.writeKeyFile(orden, " ", false);		


			for(int j = 0; j < arr.size(); j++){
				//FileManager.writeKeyFile(nombreArchivo, arr.get(j), false);
				FileManager.writeKeyFile(orden, arr.get(j), false);
			}



		}while(!ordenado);	//si ya está ordenada la lista, se termina el programa

		if(ordenado == true){	//se pasa la coleccion ordenada al archivo original
				for(int j = 0; j < arr.size(); j++){
					FileManager.writeKeyFile(nombreArchivo, arr.get(j), false);
				}
		}

		bw.close();             //...poder escribir sobre él más adelante.
		} catch (IOException ex) {
             Logger.getLogger(Mezcla.class.getName()).log(Level.SEVERE, null, ex);
        }

	}




	public static void imprimir(List<String> listaDeImpresion){

		for(String recorrido:listaDeImpresion){
			System.out.println(recorrido);
		}

	}


}