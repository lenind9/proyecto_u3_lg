package com.uce.edu.demo.service.funcional.tarea;

@FunctionalInterface
public interface IEstudianteFunction<R, T> {
	R aplicar(T arg1);
}
