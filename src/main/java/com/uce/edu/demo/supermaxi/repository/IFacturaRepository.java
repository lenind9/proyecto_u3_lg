package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura2;

public interface IFacturaRepository {
	public void insertar(Factura2 factura);
	public Factura2 buscar(Integer id);
    public void actualizar(Factura2 factura);
    public void eliminar(Integer id);
    
    public Factura2 buscarPorNumero(String numero);
}
