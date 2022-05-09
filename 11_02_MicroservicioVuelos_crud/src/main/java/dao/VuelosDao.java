package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Vuelo;

public interface VuelosDao extends JpaRepository<Vuelo, Integer> {
	
	List<Vuelo> findByPlazas(int plazas);
}
