package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	RestTemplate restTemplate;
	String urlBase ="http://servicio-alumnos/crud";
	
	public StudentServiceImpl(@Autowired RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public void altaStudent(Student student) {
		restTemplate.postForLocation(urlBase+"/Alumno",student);

	}

	@Override
	public List<Student> studentPorPuntuacionMinima(double puntuacion) {
		//Recuperamos estudiantes en un array por que no nos devuelve lista
		Student[] estudiantes = restTemplate.getForObject(urlBase+"/Alumnos", Student[].class);
		//Convertimos array a lista
		return Arrays.stream(estudiantes) //stream
		.filter(s->s.getPuntuacion()>puntuacion) //filtramos por puntuacion
		.collect(Collectors.toList()); //Convertimos a lista
		
	}

}
