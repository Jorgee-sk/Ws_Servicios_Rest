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

import model.Reserva;
import service.ReservaService;

@RestController
public class ReservasController {
	@Autowired
	ReservaService service;
	
	@PostMapping(value="Reserva",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaReserva(@RequestBody Reserva reserva, @RequestParam("plazas") int nPlazas) {
		service.altaReserva(reserva, nPlazas);
	}
	
	@GetMapping(value="Reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas(){
		return service.todasReservas();
	}
}
