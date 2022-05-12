package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Hotel;

public interface HotelesDao extends JpaRepository<Hotel, Integer>{
	
	/**
	 * 
	 * @return hoteles disponibles
	 */
	@Query("select h from Hotel h where h.disponible=1")
	List<Hotel> findHotelDisponible();
	
	/**
	 * 
	 * @param nombre
	 * @return hotel encontrado por nombre
	 */
	Hotel findByNombre(String nombre);
	
}
