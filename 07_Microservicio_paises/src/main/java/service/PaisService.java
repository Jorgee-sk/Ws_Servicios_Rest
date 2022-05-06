package service;

import java.util.List;

import model.Pais;

public interface PaisService {
	
	List<String> continentes();
	List<Pais> paisPorContinente(String region);
	long numeroHabitantes(String region);
		
	
	/*Lista de continentes
	- Paises por continente. Recibe una petición get con el nombre de un continente, y devuelve los paises
	del mismo
	- Población continente. Recibe una peticion get con el nombre de un continente, y devuelve el total de
	habitantes de dicho continente*/

}
