package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;

@Repository
@Transactional
public class FacturaElectronicaRepositoryImpl implements IFacturaElectronicaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.entityManager.persist(facturaElectronica);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public FacturaElectronica buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(FacturaElectronica.class, id);
	}

	@Override
	public void actualizar(FacturaElectronica facturaElectronica) {
		// TODO Auto-generated method stub
		this.entityManager.merge(facturaElectronica);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

}
