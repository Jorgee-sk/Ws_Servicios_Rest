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
import model.Pais;
import service.PaisesService;

@Api
@CrossOrigin("*")
@RestController
public class PaisController {
	
	@Autowired
	PaisesService service;
	
	@ApiOperation(value="Devuelve una lista de los continentes")
	@GetMapping(value="Continentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> continentes(){
		return service.continentes();
	}
	
	@ApiOperation(value="Devuelve una lista de los paises del continente solicitado")
	@GetMapping(value="PaisPorContinentes/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pais> paisesPorContinente(@ApiParam(value="Nombre del continente a buscar")@PathVariable("continente") String continente){
		return service.paisesPorContinente(continente);
	}
	
	@ApiOperation(value="Devuelve los habitantes del continente solicitado")
	@GetMapping(value="HabitantesContinentes/{continente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public long habitantesContinente(@ApiParam(value="Nombre del continente a buscar")@PathVariable("continente") String continente){
		return service.habitantesContinente(continente);
	}
}
