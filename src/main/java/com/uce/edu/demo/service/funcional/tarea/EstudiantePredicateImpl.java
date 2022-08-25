package com.uce.edu.demo.service.funcional.tarea;

public class EstudiantePredicateImpl implements IEstudiantePredicate<Integer> {

	@Override
	public boolean evaluar(Integer arg1) {
		// TODO Auto-generated method stub
		if(arg1 >= 18) {
			return true;
		}else {
			return false;
		}
	}

}
