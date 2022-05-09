package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.VuelosDao;
import model.Vuelo;
@Service
public class VuelosServiceImpl implements VuelosService{
	
	VuelosDao vuelosDao;

	public VuelosServiceImpl(@Autowired VuelosDao vuelosDao) {
		super();
		this.vuelosDao = vuelosDao;
	}

	@Override
	public Vuelo buscarVuelo(int idVuelo) {
		return vuelosDao.findById(idVuelo).orElse(null);
	}


	@Override
	public boolean actualizarVuelo(int idVuelo, int plazas) {
		Vuelo vuelo = buscarVuelo(idVuelo);
		if(vuelo!=null) {
			vuelo.setPlazas(plazas);
			vuelosDao.save(vuelo);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Vuelo> todosVuelos() {
		return vuelosDao.findAll();
	}

	@Override
	public List<Vuelo> vuelos(int plazas) {
		
		return vuelosDao.findAll()
				.stream().filter(p->p.getPlazas()>=plazas)
				.collect(Collectors.toList());
		
	}

}
