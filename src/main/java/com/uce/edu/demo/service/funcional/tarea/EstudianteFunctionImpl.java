package com.uce.edu.demo.service.funcional.tarea;

public class EstudianteFunctionImpl implements IEstudianteFunction<Integer, Long> {

	@Override
	public Integer aplicar(Long arg1) {
		// TODO Auto-generated method stub
		return arg1.intValue();
	}

}
