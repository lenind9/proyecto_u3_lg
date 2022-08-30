package com.uce.edu.demo.service.funcional.tarea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.uce.edu.demo.service.funcional.tarea.MainInterfacesFuncionales;

public class MainInterfacesFuncionales {
	
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
		//SUPPLIER
		//Clases personalizadas
		IEstudianteSupplier<String> supplierClase = new EstudianteSupplierImpl();
		LOG.info("Supplier Clase: " + supplierClase.getNombre());
		
		//Lambdas
		IEstudianteSupplier<String> supplierLambda = () -> "Lenin Lambda";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());
		
		//Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Supplier High Order");
		
		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1564745"; 
			return valorConsultado;
		});
		LOG.info("HO Supplier: " + valorHO);
		
		//CONSUMER
		//Clases personalizadas
		IEstudianteConsumer<String> consumerClase = new EstudianteConsumerImpl();
		consumerClase.accept("Consumer Clase test");
		
		//Lambdas
		IEstudianteConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Consumer Lambda test");
		
		//Metodos High Order
		metodosHO.consumirConsumer(edad -> System.out.println(edad), 22);
		
		//PREDICATE
		//Clases personalizadas
		IEstudiantePredicate<Integer>  predicateClase = new EstudiantePredicateImpl();
		LOG.info("Predicate Clase: " + predicateClase.evaluar(22));
		
		//Lambdas
		IEstudiantePredicate<String> predicateLambda = cadena -> cadena.endsWith("e");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Lenin"));
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.endsWith("n"), "Lenin");
		LOG.info("HO Predicate: " + respuesta);
		
		//FUNCTION
		//Clases personalizadas
		IEstudianteFunction<Integer, Long> functionClase = new EstudianteFunctionImpl();
		LOG.info("Function Clase: " + functionClase.aplicar(new Long(5)));
		
		//Lambdas
		IEstudianteFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor * 3;
			return valorFinal;
		};
		LOG.info("Function Lambda: " + functionLambda.aplicar("8"));
		
		//Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = "Programacion Avanzada " + valor.toString();
			return retorno;
		}, 2);
		LOG.info("HO Function: " + valorFinalHO);
		
		//FUNCTION UNARY OPERATOR
		//Clases personalizadas
		IEstudianteFunctionUnaryOperator<String> functionUnaryClase = new EstudianteFunctionUnaryOperatorImpl();
		LOG.info("Unary Operator Clase: " + functionUnaryClase.aplicar("David"));
		
		//Lambdas
		IEstudianteFunctionUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat(" Guananga");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambda: " + unaryLambda.aplicar("David"));
		
		//Metodos High Order
		String valorHOUnaryOperator = metodosHO.consumirFunctionUnaryOperator(valor -> {
			String materia = valor.toString() + " 2";
			return materia;
		}, "Programacion Avanzada");
		LOG.info("HO Unary Operator: " + valorHOUnaryOperator);
	}
	

}
