package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Alumno;
import service.AlumnosService;
@CrossOrigin("*")
@RestController
public class AlumnosController {
	@Autowired
	AlumnosService service;
	@PostMapping(value="Alumno",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaAlumno(@RequestBody Alumno alumno) {
		service.altaAlumno(alumno);
	}
	@PutMapping(value="Alumno",produces=MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@RequestParam("idAlumno") int idAlumno, @RequestParam("curso") String curso) {
		return String.valueOf(service.actualizarAlumno(idAlumno, curso));
	}
	@DeleteMapping(value="Alumno/{idAlumno}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String eliminar(@PathVariable("idAlumno") int idAlumno) {
		return String.valueOf(service.eliminarAlumno(idAlumno));
	}
	@GetMapping(value="Alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Alumno> alumnos(){
		return service.todosAlumnos();
	}
	@GetMapping(value="Alumno/{idAlumno}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Alumno buscarAlumno(@PathVariable("idAlumno") int idAlumno){
		return service.buscarAlumno(idAlumno);
	}
	@GetMapping(value="Cursos",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<String> cursos(){
		return service.cursos();
	}
}
