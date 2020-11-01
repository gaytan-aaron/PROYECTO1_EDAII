package Mezcla;

import java.util.*;
import java.io.*;		//version de mezcla equilibrada para cadenas, aun no se manejan archivos

public class Mezcla{

	
	public void mezclaEquilibrada(List<String> arr){	//lista original

		int left = 0;
		int izq = 0; 
		int right = arr.size() -1;
		int der = right;

		boolean ordenado = false;	//bandera que dirá si ya se ordenó la lista original
		do{
			left = 0;
			ordenado = true;
			
			while(left < right){
				izq = left;
				while((izq < right) && (arr.get(izq).compareTo(arr.get(izq+1)) <= 0)){
					izq++;
				}
				der = izq + 1;
				while((der == right -1) || (der < right) && (arr.get(der).compareTo(arr.get(der+1)) <= 0)){
					der++;
				}
				if(der<=right){
					mezclaDirecta(arr);
					ordenado = false;
				}
				left = izq; 
			}

		}while(!ordenado);

	}







	public void mezclaDirecta(List<String> arr){
		int i;
		int j;
		int k;
		if (arr.size() > 1){	//si aunque sea hay dos elementos se ejecuta
			int elementosIzquierda = arr.size() / 2;
			int elementosDerecha = arr.size() - elementosIzquierda;
			List<String> arr1 = new LinkedList<>();	//dos estructuras auxiliares
			List<String> arr2 = new LinkedList<>();

			for(i = 0; i < elementosIzquierda; i++){	//se pasa toda la primera mitad de la lista a una lista auxiliar
				arr1.add(i, arr.get(i));
			}

			for(i = elementosIzquierda; i < elementosIzquierda + elementosDerecha; i++){	//se pasa la segunda mitad de la lista a la otra lista auxiliar
				arr2.add(i-elementosIzquierda,arr.get(i)); 
			}

			mezclaDirecta(arr1);	
			mezclaDirecta(arr2);
			
			i = 0;
			j = 0;
			k = 0;
			while(arr1.size() != j && arr2.size() != k){
				if(	arr1.get(j).compareTo(arr2.get(k)) < 0){	//de esta manera, es primero lexicograficamente arr1.get(j) o menor
					arr.set(i,arr1.get(j)); 
					i++;
					j++;
				}else{
					arr.set(i,arr2.get(k));
					i++;
					k++;
				}
			}
			while(arr1.size() != j){
				arr.set(i,arr1.get(j));
				i++;
				j++;
			}
			while(arr2.size() != k){
				arr.set(i, arr2.get(k));
				i++;
				k++;
			}
		}

		//return arr;
	}



public void imprimir(List<String> listaDeImpresion){

	for(String recorrido:listaDeImpresion){
		System.out.println(recorrido);
	}

}





}