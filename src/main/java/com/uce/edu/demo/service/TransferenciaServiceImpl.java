package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService {
	
	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepository;
	
	@Autowired
	private ITransferenciaRepository transferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroCtaOrigen, String numeroCtaDestino, BigDecimal monto) { //begin
		//1. Buscar la cuenta origen para obtener el saldo
		CuentaBancaria ctaOrigen = this.cuentaBancariaRepository.buscarPorNumero(numeroCtaOrigen);
		
		//2. Restar el monto a la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.cuentaBancariaRepository.actualizar(ctaOrigen);
		
		//3. Buscar la cuenta destino para obtener el saldo
		CuentaBancaria ctaDestino = this.cuentaBancariaRepository.buscarPorNumero(numeroCtaDestino);
		
		//4. Sumar el monto a la cuenta destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.cuentaBancariaRepository.actualizar(ctaDestino);
		
		//5. Insertar transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.transferenciaRepository.insertar(trans);
	} //commit

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

}
