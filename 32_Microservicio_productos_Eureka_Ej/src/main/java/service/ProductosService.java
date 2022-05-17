package service;

import java.util.List;

import model.Producto;

public interface ProductosService {
	Producto buscarProducto(int codigoProducto);
	boolean actualizarProducto(int codigoProducto,int unidades);
	List<Producto> todosProductos();
	double buscarPrecioProducto(int codigoProducto);
	
}
