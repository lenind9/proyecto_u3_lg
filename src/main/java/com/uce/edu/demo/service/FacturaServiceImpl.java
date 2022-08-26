package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepository;
import com.uce.edu.demo.repository.modelo.Factura1;

@Service
public class FacturaServiceImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Override
	public List<Factura1> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidadDetalle);
	}
	
	@Override
	public List<Factura1> buscarFacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin();
	}
	
	@Override
	public List<Factura1> buscarFacturaOuterLeftJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterLeftJoin(cantidadDetalle);
	}
	
	@Override
	public List<Factura1> buscarFacturaOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterLeftJoin();
	}
	
	@Override
	public List<Factura1> buscarFacturaOuterRightJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterRightJoin(cantidadDetalle);
	}
	
	@Override
	public List<Factura1> buscarFacturaOuterRightJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterRightJoin();
	}

	@Override
	public List<Factura1> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(cantidadDetalle);
	}

	@Override
	public List<Factura1> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinFetch(cantidadDetalle);
	}

}
