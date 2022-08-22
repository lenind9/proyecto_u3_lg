package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura2;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(Factura2 factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public Factura2 buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Factura2.class, id);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Factura2 factura) {
		// TODO Auto-generated method stub
		this.entityManager.merge(factura);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Factura2 buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura2> myQuery = this.entityManager.createQuery("SELECT f FROM Factura2 f WHERE f.numero = :datoNumero", Factura2.class);
		myQuery.setParameter("datoNumero", numero);
		return myQuery.getSingleResult();
	}
	
}
