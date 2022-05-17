package service;

import java.util.List;

import model.Pedido;

public interface PedidoService {
	void altaPedido(Pedido pedido);
	List<Pedido> todosPedidos();

}
