package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	public void registrarCompraProducto(String numeroFactura, Integer cantidadItems, BigDecimal monto);
}
