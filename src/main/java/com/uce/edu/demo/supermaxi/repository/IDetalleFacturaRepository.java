package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura2;

public interface IDetalleFacturaRepository {
	public void insertar(DetalleFactura2 detalle);
	public DetalleFactura2 buscar(Integer id);
    public void actualizar(DetalleFactura2 detalle);
    public void eliminar(Integer id);
}
