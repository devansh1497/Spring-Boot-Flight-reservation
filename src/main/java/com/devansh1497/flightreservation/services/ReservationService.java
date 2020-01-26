package com.devansh1497.flightreservation.services;

import com.devansh1497.flightreservation.dto.ReservationRequestDTO;
import com.devansh1497.flightreservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequestDTO reservationRequestDTO);

}
