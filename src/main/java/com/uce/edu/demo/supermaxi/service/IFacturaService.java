package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.util.List;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura;

public interface IFacturaService {
	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> codigoBarras);
	public Factura buscarPorNumero(String numero);
}
