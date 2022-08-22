package com.uce.edu.demo.supermaxi.service;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura2;

public interface IFacturaService {
	public Factura2 buscarPorNumero(String numero);
}
