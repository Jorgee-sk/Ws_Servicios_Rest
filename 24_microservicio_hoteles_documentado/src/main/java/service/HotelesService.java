package service;

import java.util.List;

import model.Hotel;

public interface HotelesService {
	
	/**
	 * 
	 * @return hoteles disponibles
	 */
	List<Hotel> hotelesDisponibles();
	
	/**
	 * 
	 * @param nombre
	 * @return hotel encontrado 
	 */
	Hotel hotelPorNombre(String nombre);
	
	/**
	 * 
	 * @param idVuelo
	 * @return hotel encontrado
	 */
	Hotel buscarHotelPorId(int idVuelo);
	
}
