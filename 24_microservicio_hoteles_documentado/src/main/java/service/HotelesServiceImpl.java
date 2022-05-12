package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.HotelesDao;
import model.Hotel;

@Service
public class HotelesServiceImpl implements HotelesService{
	
	HotelesDao hotelesDao;

	public HotelesServiceImpl(@Autowired HotelesDao hotelesDao) {
		super();
		this.hotelesDao = hotelesDao;
	}

	@Override
	public List<Hotel> hotelesDisponibles() {
		return hotelesDao.findHotelDisponible();
	}

	@Override
	public Hotel hotelPorNombre(String nombre) {
		return hotelesDao.findByNombre(nombre);
	}

	@Override
	public Hotel buscarHotelPorId(int idHotel) {
		return hotelesDao.findById(idHotel).orElse(null);
	}
	
	
}
