package service;

import java.util.List;

import model.Reserva;

public interface ReservaService {
	void altaReserva(Reserva reserva);
	List<Reserva> todasReservas();

}
