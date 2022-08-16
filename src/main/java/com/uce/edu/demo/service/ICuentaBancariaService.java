package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	public void insertarCuentaBancaria(CuentaBancaria cuentaBancaria);
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria buscarPorNumero(String numeroCta);
}
