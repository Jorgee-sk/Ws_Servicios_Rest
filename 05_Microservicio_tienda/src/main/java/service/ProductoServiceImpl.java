package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;
@Service
public class ProductoServiceImpl implements ProductoService{
	
	ProductosDao productosDao;

	public ProductoServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}

	@Override
	public void altaProducto(Producto producto) {
		productosDao.save(producto);
		
	}

	@Override
	public Producto buscarProducto(String seccion) {
		return productosDao.findBySeccion(seccion);
	}

	@Override
	public boolean eliminarProducto(int idAlumno) {
		if(productosDao.findById(idAlumno)!=null) {
			productosDao.deleteById(idAlumno);
			return true;
		}
		return false;
	}

	@Override
	public List<Producto> todosProductos() {
		return productosDao.findAll();
	}


}
