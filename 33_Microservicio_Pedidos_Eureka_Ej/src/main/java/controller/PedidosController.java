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

import model.Pedido;
import service.PedidoService;

@CrossOrigin("*")
@RestController
public class PedidosController {
	@Autowired
	PedidoService service;
	
	@PostMapping(value="Pedido",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void altaReserva(@RequestBody Pedido pedido) {
		service.altaPedido(pedido);
	}
	
	@GetMapping(value="Pedidos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> reservas(){
		return service.todosPedidos();
	}
}
