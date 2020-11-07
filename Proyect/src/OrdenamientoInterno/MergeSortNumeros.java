package OrdenamientoInterno;

import java.util.List;
/**
 *
 * @author Team4
 */

public class MergeSortNumeros {
    
    void printList(List<Double> lista)
    { 
        int n = lista.size();
        for (int i=0; i<n; ++i) 
            System.out.print(lista.get(i) + " "); 
        System.out.println(); 
    } 
    
    void merge(List<Double> lista, int l, int m, int r)  
    { 
        int divIzq = m - l + 1; //Rango del arreglo izquierdo
        int divDer = r - m;  //Rango del arreglo derecho
  
        double Left[] = new double [divIzq]; 
        double Right[] = new double [divDer]; 
        
        //Se llenan los arreglos de división tomando los datos de la lista original
        for (int i=0; i<divIzq; ++i) 
            Left[i] = lista.get(i+1);
        for (int j=0; j<divDer; ++j) 
            Right[j] = lista.get(m+1+j);
  
        int i = 0, j = 0; 
  
        int aux = l; 
        while (i < divIzq && j < divDer) //Mientras existan elementos para MEZCLAR
        { 
            //Las comparaciones EMPIEZAN par a par con el primer elemento de cada división
            //No necesariamente mantienen una naturaleza par a par en el transcurso
            //Pero siempre se recorren las divisiones hacia la derecha, aumentando en uno
            if (Left[i] <= Right[j]) //Si un elemento de la división izq es menor o igual que uno de la derecha
            { 
                lista.set(aux, Left[i]); //Colocar al elemento menor en la lista original
                i++; //Recorrer a la derecha para la división izq
            } 
            else //Se deduce que el elemento de la división derecha fue menor
            { 
                lista.set(aux, Right[j]); //Colocar al elemento menor en el arreglo original
                j++; //Recorrer a la derecha para la división der
            } 
            aux++; //Identifica al ultimo elemento mezclado
        } 
  
        while (i < divIzq) { //Si sobraron elementos de la div izq, colocarlos en el arreglo original
            lista.set(aux, Left[i]);
            i++; 
            aux++; 
        } 
  
        while (j < divDer) { //Si sobraron elementos de la div der, colocarlos en el arreglo original
            lista.set(aux, Right[j]);
            j++; 
            aux++; 
        } 
    } 
  
    void sort(List<Double> lista, int LeftIndex, int RightIndex) { //Arreglo, extremo izquierdo y extremo derecho
        if (LeftIndex < RightIndex) { //Caso Base: Lista vacía o con un elemento
            int mid = (LeftIndex+RightIndex)/2; //Dividir lista
  
            sort(lista, LeftIndex, mid); //Parte Izquierda
            sort(lista , mid+1, RightIndex); //Parte derecha
  
            merge(lista, LeftIndex, mid, RightIndex); //Mezclar elementos
        } 
    }
    
    
}    

