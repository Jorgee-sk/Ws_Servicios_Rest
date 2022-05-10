package service;

import java.util.List;

import model.Vuelo;

public interface VuelosService {
	Vuelo buscarVuelo(int idVuelo);
	boolean actualizarVuelo(int idVuelo,int plazas);
	List<Vuelo> todosVuelos();
	List<Vuelo> vuelos(int plazas);
}
