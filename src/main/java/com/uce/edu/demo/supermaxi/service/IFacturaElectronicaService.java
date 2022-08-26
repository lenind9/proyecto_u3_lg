package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	public void procesarElectronica(String numeroFactura, Integer cantidadItems, BigDecimal monto);
}
