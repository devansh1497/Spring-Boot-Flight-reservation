package com.devansh1497.flightreservation.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devansh1497.flightreservation.dto.ReservationRequestDTO;
import com.devansh1497.flightreservation.entities.Flight;
import com.devansh1497.flightreservation.entities.Passenger;
import com.devansh1497.flightreservation.entities.Reservation;
import com.devansh1497.flightreservation.repository.FlightRepository;
import com.devansh1497.flightreservation.repository.PassengerRepository;
import com.devansh1497.flightreservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Override
	public Reservation bookFlight(ReservationRequestDTO reservationRequestDTO) {
		//Make payment
		
		long flightId = reservationRequestDTO.getFlightId();
		Flight flight = flightRepository.findById(flightId).get();
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(reservationRequestDTO.getPassengerFirstName());
		passenger.setLastName(reservationRequestDTO.getPassengerLastName());
		passenger.setEmail(reservationRequestDTO.getPassengerEmail());
		passenger.setPhone(reservationRequestDTO.getPassengerPhone());
		
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		return savedReservation;
	}

	
}
