package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
		Cajero cajero1 = new Cajero("C1", Arrays.asList("Pepito", "Juan"));
		Cajero cajero2 = new Cajero("C2", Arrays.asList("Leonardo", "Daniel"));
		Cajero cajero3 = new Cajero("C3", Arrays.asList("Andres", "Ismael"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero1);
		
		PCCajero gestorAtencion2 = new PCCajero();
		gestorAtencion2.procesar(cajero2);
		
		PCCajero gestorAtencion3 = new PCCajero();
		gestorAtencion3.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " segundos");
	}

}
