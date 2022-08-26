package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class FacturaServImpl implements IFacturaService {
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IDetalleFacturaRepository detalleFacturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		
		BigDecimal totalPagar = BigDecimal.ZERO;
		Cliente cliente = this.clienteRepository.buscarPorCedula(cedula);
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);
		
		List<DetalleFactura> detalles = new ArrayList<>();
		
		for(String codigoProducto : codigoBarras) {
			DetalleFactura deta = new DetalleFactura();
			Producto producto = this.productoRepository.buscarPorCodigoBarras(codigoProducto);
			
			deta.setCantidad(1);
			deta.setFactura(factura);
			deta.setProducto(producto);
			deta.setSubtotal(deta.getProducto().getPrecio());
			totalPagar.add(deta.getSubtotal());
			
			producto.setStock(producto.getStock() - deta.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(deta);
			//this.detalleFacturaRepository.insertar(deta);
		}
		factura.setDetalles(detalles);
		this.facturaRepository.insertar(factura);
		return totalPagar;
	}

	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarPorNumero(numero);
	}
	
}
