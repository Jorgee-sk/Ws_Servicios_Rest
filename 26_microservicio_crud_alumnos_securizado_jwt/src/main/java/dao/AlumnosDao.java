package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, Integer> {
	//opcion 1: se le da la lista de cursos ya filtrada
	/*@Query("select distinct(a.curso) from Alumno a")
	List<String> findCursos();*/
	//opción 2: no se hace el método anterior y la capa de servicio filtre a partir de la
	//lista de cursos
	 
}
