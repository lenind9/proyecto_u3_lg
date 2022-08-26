package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;

public interface IDetalleFacturaRepository {
	public void insertar(DetalleFactura detalle);
	public DetalleFactura buscar(Integer id);
    public void actualizar(DetalleFactura detalle);
    public void eliminar(Integer id);
}
