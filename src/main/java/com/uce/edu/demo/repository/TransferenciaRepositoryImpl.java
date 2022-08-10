package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY) //para que el metodo que le llame, le obligue a tener una transaccion
	public void insertar(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

}
