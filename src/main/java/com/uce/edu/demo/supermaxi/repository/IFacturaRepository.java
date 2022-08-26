package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura;

public interface IFacturaRepository {
	public void insertar(Factura factura);
	public Factura buscar(Integer id);
    public void actualizar(Factura factura);
    public void eliminar(Integer id);
    
    public Factura buscarPorNumero(String numero);
}
