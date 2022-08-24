package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService {
	
	@Autowired
	private IFacturaElectronicaRepository electronicaRepository;

	@Override
	public void registrarCompraProducto(String numeroFactura, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica electronica = new FacturaElectronica();
		electronica.setNumero(numeroFactura);
		electronica.setFechaCreacion(LocalDateTime.now());
		electronica.setNumeroItems(cantidadItems);
		electronica.setMonto(monto);
		
		this.electronicaRepository.insertar(electronica);
		throw new RuntimeException();
		
	}
	
}
