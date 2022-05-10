package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;
@Service
public class ReservaServiceImpl implements ReservaService{
	
	RestTemplate restTemplate;
	String urlBase ="http://localhost:8000/crud";
	
	ReservasDao reservasDao;

	public ReservaServiceImpl(@Autowired ReservasDao reservasDao, @Autowired RestTemplate restTemplate) {
		super();
		this.reservasDao = reservasDao;
		this.restTemplate = restTemplate;
	}
	
	@Override
	public void altaReserva(Reserva reserva, int nPlazas) {
		
		
		Vuelo[] vuelos = restTemplate.getForObject(urlBase+"/Vuelos", Vuelo[].class);
		Vuelo v = Arrays.stream(vuelos)
		.filter(s->s.getIdVuelo()==reserva.getVuelo())
		.collect(Collectors.toList()).get(0); 
		
		if(nPlazas <= v.getPlazas()) {
			reservasDao.save(reserva);
			restTemplate.put(urlBase+"/Vuelo/{idVuelo}/{plazas}",null,reserva.getVuelo(), nPlazas);
		}
		
		
	}


	@Override
	public List<Reserva> todasReservas() {
		return reservasDao.findAll();
	}


	

}
