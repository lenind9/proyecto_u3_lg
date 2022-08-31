package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
		CajeroParalelo cajero1 = new CajeroParalelo("C1", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("C2", Arrays.asList("Leonardo"));
		CajeroParalelo cajero3 = new CajeroParalelo("C3", Arrays.asList("Andres"));
		
		CajeroParalelo cajero4 = new CajeroParalelo("C1", Arrays.asList("Juan"));
		CajeroParalelo cajero5 = new CajeroParalelo("C2", Arrays.asList("Daniel"));
		CajeroParalelo cajero6 = new CajeroParalelo("C3", Arrays.asList("Ismael"));
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero1);
		gestorAtencion.start(); //ejecuta el metodo procesar
		
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();
		
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start(); //ejecuta el metodo procesar
		
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();
		
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " segundos");
	}

}
