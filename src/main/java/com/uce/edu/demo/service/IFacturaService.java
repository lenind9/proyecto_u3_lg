package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura1;

public interface IFacturaService {
	public List<Factura1> buscarFacturaInnerJoin(Integer cantidadDetalle);
	public List<Factura1> buscarFacturaInnerJoin();
	public List<Factura1> buscarFacturaOuterLeftJoin(Integer cantidadDetalle);
	public List<Factura1> buscarFacturaOuterLeftJoin();
	public List<Factura1> buscarFacturaOuterRightJoin(Integer cantidadDetalle);
	public List<Factura1> buscarFacturaOuterRightJoin();
	
	public List<Factura1> buscarFacturaJoinWhere(Integer cantidadDetalle);
	public List<Factura1> buscarFacturaJoinFetch(Integer cantidadDetalle);
}
