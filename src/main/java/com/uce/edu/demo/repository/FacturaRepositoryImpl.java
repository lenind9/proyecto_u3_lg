package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		//SELECT h FROM Hotel h INNER JOIN h.habitaciones ha WHERE ha.tipo = :tipoHabitacion
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalles de WHERE de.cantidad = :cantidadDetalle", Factura.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		
		//Bajo demanda
		List<Factura> facturas = myQuery.getResultList();
		for(Factura f : facturas) {
			f.getDetalles().size();
		}
		
		return facturas;
	}
	
	@Override
	public List<Factura> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f INNER JOIN f.detalles de", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles de WHERE de.cantidad >= :cantidadDetalle", Factura.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Factura> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles de", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles de WHERE de.cantidad >= :cantidadDetalle", Factura.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Factura> buscarFacturaOuterRightJoin() {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f RIGHT JOIN f.detalles de", Factura.class);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura df WHERE f = df.factura AND df.cantidad = :cantidadDetalle", Factura.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN FETCH f.detalles de WHERE de.cantidad = :cantidadDetalle", Factura.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

}
