package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.Arrays;

public class MainParaleloTarea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre del hilo: " + Thread.currentThread().getName());
		EntradaCineParalelo entrada1 = new EntradaCineParalelo("Ventanilla 1", Arrays.asList("00054", "00055", "00056"));
		EntradaCineParalelo entrada2 = new EntradaCineParalelo("Ventanilla 5", Arrays.asList("00057"));
		EntradaCineParalelo entrada3 = new EntradaCineParalelo("Ventanilla 6", Arrays.asList("00045", "00046"));
		EntradaCineParalelo entrada4 = new EntradaCineParalelo("Ventanilla 2", Arrays.asList("00031", "00030"));
		EntradaCineParalelo entrada5 = new EntradaCineParalelo("Ventanilla 3", Arrays.asList("00066"));
		
		CineParalelo gestorCine = new CineParalelo(entrada1);
		gestorCine.start();
		
		CineParalelo gestorCine2 = new CineParalelo(entrada2);
		gestorCine2.start();
		
		CineParalelo gestorCine3 = new CineParalelo(entrada3);
		gestorCine3.start();
		
		CineParalelo gestorCine4 = new CineParalelo(entrada4);
		gestorCine4.start();
		
		CineParalelo gestorCine5 = new CineParalelo(entrada5);
		gestorCine5.start();
		
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " segundos");
		
	}

}
