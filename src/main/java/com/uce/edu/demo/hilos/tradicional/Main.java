package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero1 = new Cajero("C1", Arrays.asList("Pepito", "Juan", "Daniela", "Lisette"));
		Cajero cajero2 = new Cajero("C2", Arrays.asList("Leonardo", "Daniel", "Alina"));
		Cajero cajero3 = new Cajero("C3", Arrays.asList("Andres", "Ismael"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " segundos");
	}

}
