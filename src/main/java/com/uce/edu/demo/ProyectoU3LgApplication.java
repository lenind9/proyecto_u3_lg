package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Inner Join
		LOG.info("INNER JOIN");
		List<Factura> listaFacturas = this.facturaService.buscarFacturaInnerJoin(6);
		for(Factura f : listaFacturas){
			LOG.info("Factura: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
		List<Factura> listaFacturas2 = this.facturaService.buscarFacturaInnerJoin();
		for(Factura f : listaFacturas2){
			LOG.info("Factura 2: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
		//Left Join
		LOG.info("LEFT JOIN");
		List<Factura> listaFacturasLeft = this.facturaService.buscarFacturaOuterLeftJoin(6);
		for(Factura f : listaFacturasLeft){
			LOG.info("Factura: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
		List<Factura> listaFacturasLeft2 = this.facturaService.buscarFacturaOuterLeftJoin();
		for(Factura f : listaFacturasLeft2){
			LOG.info("Factura 2: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
		//Right Join
		LOG.info("RIGHT JOIN");
		List<Factura> listaFacturasRight = this.facturaService.buscarFacturaOuterRightJoin(6);
		for(Factura f : listaFacturasRight){
			LOG.info("Factura: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
		List<Factura> listaFacturasRight2 = this.facturaService.buscarFacturaOuterRightJoin();
		for(Factura f : listaFacturasRight2){
			LOG.info("Factura 2: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
	}

}
