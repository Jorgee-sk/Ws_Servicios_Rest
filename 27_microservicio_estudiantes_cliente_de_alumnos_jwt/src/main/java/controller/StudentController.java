package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Student;
import service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	@PostMapping(value="Student",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaStudent(@RequestBody Student student) {
		service.altaStudent(student);
	}
	@GetMapping(value="Students/{puntuacion}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Student> estudiantesPuntuacion(@PathVariable("puntuacion") double puntuacion){
		return service.studentPorPuntuacionMinima(puntuacion);
	}
}
