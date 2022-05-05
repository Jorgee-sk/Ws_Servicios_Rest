package service;

import java.util.List;

import model.Pagina;

public interface BuscadorService {
	List <Pagina> buscar(String tematica);
	List <Pagina> paginas();
	void añadirPagina(Pagina p);
	void eliminar(String tematica);
	void actualizarTematica(String direccion,String nuevaTematica);
	Pagina actualizar(Pagina p);
}
