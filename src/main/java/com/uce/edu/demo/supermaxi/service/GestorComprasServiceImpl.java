package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura2;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura2;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class GestorComprasServiceImpl implements IGestorComprasService {
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IDetalleFacturaRepository detalleFacturaRepository;
	
	@Autowired
	private IFacturaRepository facturaRepository;
	
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFactura(String cedula, String numeroFactura, List<String> codigoBarras) {
		// TODO Auto-generated method stub
		Cliente cliente = this.clienteRepository.buscarPorCedula(cedula);
		Factura2 factura = new Factura2();
		
		factura.setClientes(cliente);
		factura.setNumero(numeroFactura);
		factura.setFecha(LocalDateTime.now());
		
		this.facturaRepository.insertar(factura);
		Integer items = 0;
		BigDecimal monto = new BigDecimal(0);
		for(String codigo : codigoBarras) {
			DetalleFactura2 detalle = new DetalleFactura2();
			Producto producto = this.productoRepository.buscarPorCodigoBarras(codigo);
			detalle.setCantidad(1);
			detalle.setFactura(factura);
			detalle.setProducto(producto);
			detalle.setSubtotal(producto.getPrecio().multiply(new BigDecimal(detalle.getCantidad())));
			this.detalleFacturaRepository.insertar(detalle);
			
			items += detalle.getCantidad();
			actualizarStock(producto, detalle.getCantidad());
		}
		//factura.setDetalles();
		this.facturaRepository.actualizar(factura);
		crearFacturaElectronica(numeroFactura, monto, items);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public void actualizarStock(Producto producto, Integer cantidad) {
		producto.setStock(producto.getStock() - cantidad);
        this.productoRepository.actualizar(producto);
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void crearFacturaElectronica(String numeroFactura, BigDecimal monto, Integer items) {
		
		FacturaElectronica facturaElectronica = new FacturaElectronica();
		facturaElectronica.setNumero(numeroFactura);
        facturaElectronica.setFechaCreacion(LocalDateTime.now());
        facturaElectronica.setMonto(monto);
        facturaElectronica.setNumeroItems(items);
        
        this.facturaElectronicaRepository.insertar(facturaElectronica);
	}

}
