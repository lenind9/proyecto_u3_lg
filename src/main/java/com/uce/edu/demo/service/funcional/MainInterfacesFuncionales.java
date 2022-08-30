package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {
	
	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static boolean prueba(Integer numero) {
		return numero >= 3;
	}
	
	public static void imprimir(String cadena) {
		LOG.info("Impresion: " + cadena);
	}
	
	public static void guardar(String elementoAInsertar) {
		//Consumo del repository para guardar
	}
	
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
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Lenin 3").limit(2); //interfaz de tipo Supplier
		test.forEach(cadena -> System.out.println(cadena));
		
		//CONSUMER
		//Clases personalizadas
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);
		
		//JAVA
		LOG.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero)); //interfaz de tipo Consumer
		
		//PREDICATE
		//Clases personalizadas
		//Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Predicate Lambda: " + predicateLambda.evaluar("Lenin"));  
		
		//Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("n"), "Lenin");
		LOG.info("HO Predicate: " + respuesta);
		
		//JAVA
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> prueba(numero)); //prueba(numero) debe retornar un boolean
		nuevaLista.forEach(numero -> System.out.println(numero));
		
		//JAVA
		LOG.info("JAVA Function");
		//Conversiones/cast Empleado -> EmpleadoDTO
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valor = numeroLista + 1;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		//Declarativa: ideas/intenciones
		listaCambiada.forEach(valor -> imprimir(valor));
		
		//Colecciones:
		/*List<String> lista1 = new ArrayList<>();
		Map<String, String> map1 = new HashMap<String, String>();*/
		
		//Imperativa: paso a paso
		/*for(String valor : ) {
			imprimir(valor)
		}*/
		
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
