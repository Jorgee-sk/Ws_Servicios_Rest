package service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.Vuelo;
@Service
public class ReservaServiceImpl implements ReservaService{
	
	RestTemplate restTemplate;
	String urlBase ="http://localhost:8000/V";
	
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
		.filter(s->s.getIdvuelo()==reserva.getVuelo())
		.collect(Collectors.toList()).get(0); 
		
		if(nPlazas <= v.getPlazas()) {
			
			ResponseEntity<String> response= restTemplate.exchange(urlBase+"/Vuelo/{idVuelo}/{plazas}",
					HttpMethod.PUT,
					null,
					String.class,
					reserva.getVuelo(), 
					nPlazas);
			
			String cuerpo = response.getBody();
			if(cuerpo.equals("true"))
				reservasDao.save(reserva);
		}
		
		
	}


	@Override
	public List<Reserva> todasReservas() {
		return reservasDao.findAll();
	}


	

}
