package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import model.Hotel;
import service.HotelesService;

@Api
@CrossOrigin("*")
@RestController
public class HotelesController {

	@Autowired
	HotelesService service;
	
	@ApiOperation(value="Devuelve una lista de los hoteles disponibles")
	@GetMapping(value ="Hoteles",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hotel> hoteles(){
		return service.hotelesDisponibles();
	}
	
	@ApiOperation(value="Devuelve el hotel encontrado con el nombre de la url")
	@GetMapping(value ="Hotel/{nombre}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotel(@ApiParam(value="Nombre del hoter a buscar")@PathVariable("nombre") String nombre){
		return service.hotelPorNombre(nombre);
	}
	
	@ApiOperation(value="Devuelve el hotel encontrado con el id enviado")
	@GetMapping(value ="Hotel/find/{idVuelo}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Hotel buscarHotelPorId(@PathVariable("idVuelo") int idVuelo){
		return service.buscarHotelPorId(idVuelo);
	}
	
}
