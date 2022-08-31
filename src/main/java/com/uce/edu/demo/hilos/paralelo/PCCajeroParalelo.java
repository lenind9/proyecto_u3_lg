package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class PCCajeroParalelo extends Thread {
	
	private CajeroParalelo cajero;
	
	public PCCajeroParalelo(CajeroParalelo cajero) {
		this.cajero = cajero;
	}
	
	//Siempre se debe sobreescribir el metodo run y este dispara el metodo paralelizar
	@Override
	public void run() {
		this.procesar(this.cajero);
	}
	
	public void procesar(CajeroParalelo cajero) {
		long tiempoInicial = System.currentTimeMillis();
		System.out.println("Nombre del hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando cajero: " + cajero.getNombre());
		for(String cliente : cajero.getClientes()) {
			this.atenderCliente(cliente);
		}
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		System.out.println(tiempoTranscurrido + " segundos");
		
		System.out.println("Termino: " + cajero.getNombre() + " en: " + tiempoTranscurrido + " segundos");
	}
	
	private void atenderCliente(String cliente) {
		System.out.println("Atendiendo a: " + cliente);
		//Demorar el metodo 5 segundos
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
