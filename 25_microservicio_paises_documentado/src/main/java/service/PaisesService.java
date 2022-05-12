package service;

import java.util.List;

import model.Pais;

public interface PaisesService {

	List<String> continentes();
	
	List<Pais> paisesPorContinente(String continente);
	
	long habitantesContinente(String continente);

}
