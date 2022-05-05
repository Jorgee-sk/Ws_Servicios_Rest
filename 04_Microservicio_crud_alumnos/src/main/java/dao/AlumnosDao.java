package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno, Integer> {
	@Query("select distinct(a.curso) from Alumno a")
	List<String> findCursos();
}
