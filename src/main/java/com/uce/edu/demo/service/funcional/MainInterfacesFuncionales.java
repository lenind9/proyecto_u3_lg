package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		
		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();
		
		//SUPPLIER
		//Clases personalizadas
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Lenin 2";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = () -> "Daniel TE2";
		LOG.info("Supplier Lambda: " + supplierLambdaTE.getNombre());
		
		//Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo");
		LOG.info("HO Supplier: " + valorHO);
		
		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1750360411";
			return valorConsultado;
		});
		LOG.info("HO Supplier: " + valorHO1); 
		
		//JAVA
		
		//CONSUMER
		//Clases personalizadas
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
		
		//PREDICATE
		//Clases personalizadas
		//Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Lenin"));  
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("n"), "Lenin");
		LOG.info("HO Predicate: " + respuesta);
		
		//FUNCTION
		//Clases personalizadas
		//Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambda: " + functionLambda.aplicar("7"));
		
		//Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFinalHO);
		
		//UNARY OPERATOR (FUNCTION)
		//Clases personalizadas
		//Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat(" sufijo");
			return valorFinal;
		};
		LOG.info("Unary Operator Lambda: " + unaryLambda.apply("Daniel"));
	}
}
