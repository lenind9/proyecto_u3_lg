package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3LgApplication implements CommandLineRunner {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3LgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Inner Join
		/*LOG.info("INNER JOIN");
		List<Hotel> listaHoteles = this .hotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h : listaHoteles){
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHoteles2 = this .hotelService.buscarHotelInnerJoin();
		for(Hotel h : listaHoteles2){
			LOG.info("Hotel 2: " + h.getNombre() + " " + h.getDireccion());
		}
		
		//Left Join
		LOG.info("LEFT JOIN");
		List<Hotel> listaHotelesLeft = this .hotelService.buscarHotelOuterLeftJoin("Familiar");
		for(Hotel h : listaHotelesLeft){
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		List<Hotel> listaHotelesLeft2 = this .hotelService.buscarHotelOuterLeftJoin();
		for(Hotel h : listaHotelesLeft2){
			LOG.info("Hotel 2: " + h.getNombre() + " " + h.getDireccion());
		}
		
		//Right Join
		LOG.info("RIGHT JOIN");
		List<Hotel> listaHotelesRight = this .hotelService.buscarHotelOuterRightJoin("Familiar");
		for(Hotel h : listaHotelesRight){
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}*/
		
		LOG.info("RELACIONAMIENTO WHERE");
		List<Hotel> listaHoteles = this .hotelService.buscarHotelJoinWhere("Familiar");
		for(Hotel h : listaHoteles){
			LOG.info("Hotel: " + h.getNombre() + " " + h.getDireccion());
		}
		
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles2 = this .hotelService.buscarHotelInnerJoin("Familiar");
		for(Hotel h : listaHoteles2){
			LOG.info("Hotel 2: " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				LOG.info("Habitacion 2: " + ha);
			}
			
		}
		
		LOG.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this .hotelService.buscarHotelJoinFetch("Familiar");
		for(Hotel h : listaHoteles3){
			LOG.info("Hotel 3: " + h.getNombre() + " " + h.getDireccion());
			for (Habitacion ha : h.getHabitaciones()) {
				LOG.info("Habitacion 3: " + ha);
			}
			
		}
		
	}

}
