package service;

import java.util.List;

import model.Alumno;

public interface AlumnosService {
	void altaAlumno(Alumno alumno);
	Alumno buscarAlumno(int idAlumno);
	boolean eliminarAlumno(int idAlumno);
	boolean actualizarAlumno(int idAlumno, String curso);
	List<Alumno> todosAlumnos();
	List<String> cursos();
}
