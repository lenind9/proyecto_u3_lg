package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

public interface IClienteRepository {
	public void insertar(Cliente cliente);
	public Cliente buscar(Integer id);
    public void actualizar(Cliente cliente);
    public void eliminar(Integer id);
    
	public Cliente buscarPorCedula(String cedula);
}
