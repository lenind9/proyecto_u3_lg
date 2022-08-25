package com.uce.edu.demo.service.funcional.tarea;

public class ConsumoMetodosHighOrder {
	public String consumirSupplier(IEstudianteSupplier<String> funcion) {
		return funcion.getNombre();
	}
	
	public void consumirConsumer(IEstudianteConsumer<Integer> funcion, Integer valor) {
		funcion.accept(valor);
	}
	
	public boolean consumirPredicate(IEstudiantePredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
	}
	
	public String consumirFunction(IEstudianteFunction<String, Integer> funcion, Integer valor) {
		return funcion.aplicar(valor);
	}
	
	public String consumirFunctionUnaryOperator(IEstudianteFunctionUnaryOperator<String> funcion, String valor) {
		return funcion.aplicar(valor);
	}
}
