package com.uce.edu.demo.supermaxi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;

@Service
public class FacturaServImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	public com.uce.edu.demo.supermaxi.repository.modelo.Factura2 buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarPorNumero(numero);
	}
	
	

}
