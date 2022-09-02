package com.uce.edu.demo.hilos.stream.tarea;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainStream {
	
	private static Logger LOG = Logger.getLogger(MainStream.class);
	
	public static void main(String[] args) {
		
		//Supplier
		LOG.info("JAVA Supplier");
		Stream<String> nombre = Stream.generate(() -> "Tool").limit(3);
		nombre.forEach(cadena -> System.out.println(cadena));
		
		//Consumer
		LOG.info("JAVA Consumer");
		List<String> listaCanciones = Arrays.asList("Pnuema", "Lateralus", "Descending", "7empest");
		listaCanciones.forEach(canciones -> System.out.println(canciones));
		
		//Predicate
		LOG.info("JAVA Predicate");
		List<String> listaAlbumes = Arrays.asList("10,000 Days", "Lateralus", "Fear Inoculum");
		Stream<String> lista = listaAlbumes.stream().filter(vacio -> vacio.contains("l"));
		lista.forEach(albumes -> System.out.println(albumes));
		
		//Function
		LOG.info("JAVA Function");
		Stream<String> listaModificada = Arrays.asList(1, 2, 3, 4, 5).stream().map(numero -> {
			Integer valor = numero + 1;
			String cadena = valor.toString();
			return cadena;
		});
		listaModificada.forEach(valor -> System.out.println(valor));
	}
}
