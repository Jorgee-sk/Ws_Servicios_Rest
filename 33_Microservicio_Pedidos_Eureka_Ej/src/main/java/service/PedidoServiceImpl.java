package service;

import java.security.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.PedidosDao;
import model.Pedido;
import model.Producto;
@Service
public class PedidoServiceImpl implements PedidoService{
	
	RestTemplate restTemplate;
	String urlBase ="http://localhost:8000/Productos";
	
	PedidosDao pedidosDao;

	public PedidoServiceImpl(@Autowired PedidosDao pedidosDao, @Autowired RestTemplate restTemplate) {
		super();
		this.pedidosDao = pedidosDao;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public void altaPedido(Pedido pedido) {
		
		
		Producto[] productos = restTemplate.getForObject(urlBase+"/Productos", Producto[].class);
		Producto p = Arrays.stream(productos)
		.filter(s->s.getCodigoProducto()==pedido.getCodigoProducto())
		.collect(Collectors.toList()).get(0); 
		
		if(pedido.getUnidades() <= p.getStock()) {
			
			ResponseEntity<String> response= restTemplate.exchange(urlBase+"/Producto/{codigoProducto}/{unidades}",
					HttpMethod.PUT,
					null,
					String.class,
					pedido.getCodigoProducto(), 
					pedido.getUnidades());
			pedido.setTotal(pedido.getUnidades()*p.getPrecioUnitario());
			Date d = new Date(System.currentTimeMillis());
			pedido.setFechaPedido(d);
			String cuerpo = response.getBody();
			if(cuerpo.equals("true"))
				pedidosDao.save(pedido);
		}
		
		
	}


	@Override
	public List<Pedido> todosPedidos() {
		return pedidosDao.findAll();
	}


	

}
