package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

public interface IProductoRepository {
	public void insertar(Producto producto);
	public Producto buscar(Integer id);
    public void actualizar(Producto producto);
    public void eliminar(Integer id);
    
    public Producto buscarPorCodigoBarras(String codigoBarras);
}
