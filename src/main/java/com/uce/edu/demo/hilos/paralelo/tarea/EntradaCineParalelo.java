package com.uce.edu.demo.hilos.paralelo.tarea;

import java.util.List;

public class EntradaCineParalelo {
	
	private String ventanilla;
	private List<String> entradas;
	
	public EntradaCineParalelo(String ventanilla, List<String> entradas) {
		super();
		this.ventanilla = ventanilla;
		this.entradas = entradas;
	}
	
	//SET y GET
	public String getVentanilla() {
		return ventanilla;
	}

	public void setVentanilla(String ventanilla) {
		this.ventanilla = ventanilla;
	}

	public List<String> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<String> entradas) {
		this.entradas = entradas;
	}
	
}
