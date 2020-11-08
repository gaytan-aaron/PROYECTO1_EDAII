package Mezcla;

import java.util.*;
import Mezcla.Mezcla;


public class Prueba{

	public static void main(String[] args){
		

		List<String> lista = new LinkedList<>();

		

		lista.add("Famigo");
		lista.add("Zetas");

		lista.add("Como");
		lista.add("Estas");
		lista.add("Fernando");

		lista.add("Cadena");
		lista.add("Marco");

		lista.add("Antonio");
		lista.add("Sanchez");

		lista.add("Antonio");
		lista.add("Emanuel");
		lista.add("Run to you");
		lista.add("Yes");
		lista.add("Zoom");

		lista.add("Borja");
		lista.add("Garcia");
		lista.add("Marquez");
		lista.add("Cuben");
		//lista.add("Dario");

		Mezcla prueba = new Mezcla();
		prueba.mezclaEquilibrada(lista);

		//prueba.imprimir(lista);


	}

}