package com.uce.edu.demo.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.IHotelRespository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {
	
	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IHotelRespository hotelRespository;
	
	@Override
	public boolean insertarHotel(Hotel h) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			this.hotelRespository.insertarHotel(h);
			flag = true;
		} catch(Exception e) {
			LOG.info(e.getMessage());
		}
		return flag;
	}
	
	@Override
	public Hotel buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarPorId(id);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarHotelInnerJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarHotelInnerJoin();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarHotelOuterLeftJoin(tipoHabitacion);
	}
	
	@Override
	public List<Hotel> buscarHotelOuterLeftJoin() {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarHotelOuterLeftJoin();
	}
	
	@Override
	public List<Hotel> buscarHotelOuterRightJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarHotelOuterRightJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinWhere(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRespository.buscarHotelJoinWhere(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelJoinFetch(String tipoHabitacion) {
		// TODO Auto-generated method stub
		LOG.info("Transaccion activa service: " + TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRespository.buscarHotelJoinFetch(tipoHabitacion);
	}
	
}
