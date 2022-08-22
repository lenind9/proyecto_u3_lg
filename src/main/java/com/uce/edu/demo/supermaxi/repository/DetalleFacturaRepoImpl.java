package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura2;

@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(DetalleFactura2 detalle) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalle);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public DetalleFactura2 buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(DetalleFactura2.class, id);
	}

	@Override
	public void actualizar(DetalleFactura2 detalle) {
		// TODO Auto-generated method stub
		this.entityManager.merge(detalle);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}
	
}
