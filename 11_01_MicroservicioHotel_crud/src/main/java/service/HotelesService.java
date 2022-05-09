package service;

import java.util.List;

import model.Hotel;

public interface HotelesService {
	
	Hotel buscarHotel(String nombre);
	List<Hotel> hotelesDisponibles();
	List<Hotel> todosHoteles();
}
