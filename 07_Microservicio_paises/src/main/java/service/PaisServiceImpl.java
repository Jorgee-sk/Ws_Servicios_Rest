package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Pais;

@Service
public class PaisServiceImpl implements PaisService {
	
	RestTemplate restTemplate;
	String urlBase ="https://restcountries.com/v2/all";
	
	public PaisServiceImpl(@Autowired RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public List<String> continentes() {
		Pais[] continentes = restTemplate.getForObject(urlBase, Pais[].class);
		return Arrays.stream(continentes).map(s->s.getContinente()).distinct().collect(Collectors.toList());
		
	}

	@Override
	public List<Pais> paisPorContinente(String region) {
		Pais[] continentes = restTemplate.getForObject(urlBase, Pais[].class);
	
		return Arrays.stream(continentes)
		.filter(s->s.getContinente().equals(region))
		.collect(Collectors.toList());
	}

	@Override
	public long numeroHabitantes(String region) {
		Pais[] continentes = restTemplate.getForObject(urlBase, Pais[].class);
		
		return Arrays.stream(continentes)
				.filter(s->s.getContinente().equals(region)).mapToLong(p->p.getPoblacion()).sum();
			

	}

}
