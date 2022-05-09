package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Hotel;
import service.HotelesService;

@RestController
public class HotelesController {
	@Autowired
	HotelesService service;
	
	
	@GetMapping(value="Hoteles",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.todosHoteles();
	}
	
	@GetMapping(value="Hoteles/{nombre}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotel(@PathVariable("nombre") String nombre){
		return service.buscarHotel(nombre);
	}
	
	@GetMapping(value="Hoteles/Disponibles",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> buscarHotelDisponible(){
		return service.hotelesDisponibles();
	}
	
}
