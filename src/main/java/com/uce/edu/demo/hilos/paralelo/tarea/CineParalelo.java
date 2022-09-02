package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.concurrent.TimeUnit;

public class CineParalelo extends Thread {
	
	private EntradaCineParalelo cine;
	
	public CineParalelo(EntradaCineParalelo cine) {
		this.cine = cine;
	}
	
	@Override
	public void run() {
		this.procesar(cine);
	}
	
	public void procesar(EntradaCineParalelo cine) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre del hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando ventanilla: " + cine.getVentanilla());
		for(String entrada : cine.getEntradas()) {
			this.comprarEntrada(entrada);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " segundos");
		
		System.out.println("Termino: " + cine.getVentanilla() + " en: " + tiempoTranscurrido + " segundos");
	}
	
	private void comprarEntrada(String numEntrada) {
		System.out.println("Comprando entrada: " + numEntrada);
		//Demorar el metodo 5 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
