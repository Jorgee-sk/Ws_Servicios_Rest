package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AlumnosDao;
import model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	AlumnosDao alumnosDao;
	
	public AlumnosServiceImpl(@Autowired AlumnosDao alumnosDao) {
		super();
		this.alumnosDao = alumnosDao;
	}

	@Override
	public void altaAlumno(Alumno alumno) {
		alumnosDao.save(alumno);
	}

	@Override
	public Alumno buscarAlumno(int idAlumno) {
		return alumnosDao.findById(idAlumno).orElse(null);
	}

	@Override
	public boolean eliminarAlumno(int idAlumno) {
		if(buscarAlumno(idAlumno)!=null) {
			alumnosDao.deleteById(idAlumno);
			return true;
		}
		return false;
	}

	@Override
	public boolean actualizarAlumno(int idAlumno, String curso) {
		Alumno alumno=buscarAlumno(idAlumno);
		if(alumno!=null) {
			alumno.setCurso(curso);
			alumnosDao.save(alumno);
			return true;
		}
		return false;
	}

	@Override
	public List<Alumno> todosAlumnos() {
		return alumnosDao.findAll();
	}

	@Override
	public List<String> cursos() {
		return alumnosDao.findAll()
				.stream()
				.map(a->a.getCurso()) //stream con los nombres de curso
				.distinct()//stream sin duplicados
				.collect(Collectors.toList());
				
	}

}
