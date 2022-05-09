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

import model.Vuelo;
import service.VuelosService;

@RestController
public class VuelosController {
	@Autowired
	VuelosService service;
	
	@PutMapping(value="Vuelo/{idVuelo}/{plazas}",produces = MediaType.TEXT_PLAIN_VALUE)
	public String actualizar(@PathVariable("idVuelo") int idVuelo,
							@PathVariable("plazas") int plazas) {
		return String.valueOf(service.actualizarVuelo(idVuelo, plazas));
	}

	
	@GetMapping(value="Vuelos",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelos(){
		return service.todosVuelos();
	}
	
	@GetMapping(value="Vuelo/{idVuelo}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Vuelo buscarAlumno(@PathVariable("idVuelo") int idVuelo){
		return service.buscarVuelo(idVuelo);
	}
	
	@GetMapping(value="Vuelos/{plazas}",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> vuelosByPlazas(@PathVariable("plazas") int plazas){
		return service.vuelos(plazas);
	}
}
