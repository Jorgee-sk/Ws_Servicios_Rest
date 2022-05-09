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
		reservasDao.save(reserva);
		
		Vuelo[] vuelos = restTemplate.getForObject(urlBase+"/Vuelos", Vuelo[].class);
		List<Vuelo> v = Arrays.stream(vuelos)
		.filter(s->s.getIdVuelo()==reserva.getVuelo())
		.collect(Collectors.toList()); 
		
		restTemplate.put(urlBase+"/Vuelo/{idVuelo}/{plazas}"
				, v.get(0), v.get(0).getIdVuelo(), v.get(0).getPlazas()-nPlazas);
	}


	@Override
	public List<Reserva> todasReservas() {
		return reservasDao.findAll();
	}


	

}
