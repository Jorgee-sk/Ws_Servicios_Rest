package service;

import java.util.List;

import model.Producto;

public interface ProductoService {
	void altaProducto(Producto producto);
	Producto buscarProducto(String seccion);
	boolean eliminarProducto(int idProducto);
	List<Producto> todosProductos();
}
