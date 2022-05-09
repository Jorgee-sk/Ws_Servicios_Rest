package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Reserva;

public interface ReservasDao extends JpaRepository<Reserva, Integer> {
	
}
