package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.service.IGestorComprasService;

@SpringBootApplication
public class ProyectoU3LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IGestorComprasService gestorComprasService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<String> codigoBarras = new ArrayList<String>();
		codigoBarras.add("651");
		codigoBarras.add("741");
		this.gestorComprasService.crearFactura("1724116325", "15420", codigoBarras);
	}

}
