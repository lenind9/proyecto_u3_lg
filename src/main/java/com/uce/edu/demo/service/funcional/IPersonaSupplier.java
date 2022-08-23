package com.uce.edu.demo.service.funcional;

@FunctionalInterface //no obligatorio pero si recomendable
public interface IPersonaSupplier<T> { //<T>: tipo de dato generico
	public T getNombre();
}
