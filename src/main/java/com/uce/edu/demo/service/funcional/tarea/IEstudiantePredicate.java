package com.uce.edu.demo.service.funcional.tarea;

@FunctionalInterface
public interface IEstudiantePredicate<T> {
	public boolean evaluar(T arg1);
}
