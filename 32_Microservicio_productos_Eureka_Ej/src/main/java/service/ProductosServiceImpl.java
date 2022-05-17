package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductosDao;
import model.Producto;
@Service
public class ProductosServiceImpl implements ProductosService{
	
	ProductosDao productosDao;

	public ProductosServiceImpl(@Autowired ProductosDao productosDao) {
		super();
		this.productosDao = productosDao;
	}

	@Override
	public Producto buscarProducto(int codigoProducto) {
		return productosDao.findById(codigoProducto).orElse(null);
	}


	@Override
	public boolean actualizarProducto(int codigoProducto, int unidadesCompradas) {
		Producto prod = buscarProducto(codigoProducto);
		if(prod!=null) {
			prod.setStock(prod.getStock()-unidadesCompradas);
			productosDao.save(prod);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Producto> todosProductos() {
		return productosDao.findAll();
	}

	@Override
	public double buscarPrecioProducto(int codigoProducto) {
		Producto p = buscarProducto(codigoProducto);
		return p.getPrecioUnitario();
	}

}
