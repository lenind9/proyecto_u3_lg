package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.DetalleFactura;
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
		
		LOG.info("RELACIONAMIENTO WHERE");
		List<Factura> listaFacturas = this.facturaService.buscarFacturaJoinWhere(8);
		for(Factura f : listaFacturas){
			LOG.info("Factura: " + f.getFecha() + " numero: " + f.getNumero());
		}
		
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Factura> listaFacturas2 = this.facturaService.buscarFacturaInnerJoin(8);
		for(Factura f : listaFacturas2){
			LOG.info("Factura 2: " + f.getFecha() + " numero: " + f.getNumero());
			for (DetalleFactura df : f.getDetalles()) {
				LOG.info("Detalle 2: " + df);
			}
		}
		
		LOG.info("JOIN FETCH");
		List<Factura> listaFacturas3 = this.facturaService.buscarFacturaJoinFetch(8);
		for(Factura f : listaFacturas3){
			LOG.info("Factura 3: " + f.getFecha() + " numero: " + f.getNumero());
			for (DetalleFactura df : f.getDetalles()) {
				LOG.info("Detalle 3: " + df);
			}

		}
		
	}

}
