package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;
import com.uce.edu.demo.supermaxi.service.IGestorComprasService;

@SpringBootApplication
public class ProyectoU3LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IGestorComprasService gestorComprasService;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setCedula("1750368084");
		cliente.setNumeroTarjeta("5422321021598708");
		this.clienteRepository.insertar(cliente);
		
		Producto producto = new Producto();
		producto.setNombre("Dr Pepper");
		producto.setCodigoBarras("65");
		producto.setPrecio(new BigDecimal(2.5));
		producto.setStock(40);
		this.productoRepository.insertar(producto);
		
		Producto producto2 = new Producto();
		producto2.setNombre("Froot Loops");
		producto2.setCodigoBarras("99");
		producto2.setPrecio(new BigDecimal(3.5));
		producto2.setStock(20);
		this.productoRepository.insertar(producto2);
		
		Producto producto3 = new Producto();
		producto3.setNombre("Queso Mozzarella");
		producto3.setCodigoBarras("24");
		producto3.setPrecio(new BigDecimal(5));
		producto3.setStock(25);
		this.productoRepository.insertar(producto3);
		
		List<String> detalles = new ArrayList<>();
		detalles.add(producto.getCodigoBarras());
		detalles.add(producto2.getCodigoBarras());
		detalles.add(producto3.getCodigoBarras());
		
		this.gestorComprasService.registrarCompraProducto("1750368084", "712440", detalles);
	}

}
