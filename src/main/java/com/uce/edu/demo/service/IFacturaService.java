package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {
	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);
	public List<Factura> buscarFacturaInnerJoin();
	public List<Factura> buscarFacturaOuterLeftJoin(Integer cantidadDetalle);
	public List<Factura> buscarFacturaOuterLeftJoin();
	public List<Factura> buscarFacturaOuterRightJoin(Integer cantidadDetalle);
	public List<Factura> buscarFacturaOuterRightJoin();
	
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle);
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle);
}
