package Mezcla;

import java.util.*;
import Mezcla.Mezcla;

public class Prueba{

	public static void main(String[] args){
		

		List<String> lista = new LinkedList<>();

		lista.add(0, "Probando una cadena larga");

		lista.add("Hola");
		lista.add("Como");
		lista.add("Estas");
		lista.add("Amigo");
		lista.add("Cadena");
		lista.add("Marco");
		lista.add("Sanchez");
		lista.add("Antonio");
		lista.add("Emanuel");
		lista.add("Zoom");
		lista.add("Borja");
		lista.add("Garcia");
		lista.add("Marquez");
		lista.add("Ruben");
		lista.add("Dario");

		Mezcla prueba = new Mezcla();
		prueba.mezclaEquilibrada(lista);

		prueba.imprimir(lista);


	}

}