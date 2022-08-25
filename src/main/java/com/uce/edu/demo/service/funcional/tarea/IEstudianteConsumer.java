package com.uce.edu.demo.service.funcional.tarea;

@FunctionalInterface
public interface IEstudianteConsumer<T> {
	public void accept(T arg1);
}
