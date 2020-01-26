package com.devansh1497.flightreservation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devansh1497.flightreservation.dto.ReservationRequestDTO;
import com.devansh1497.flightreservation.entities.Flight;
import com.devansh1497.flightreservation.entities.Reservation;
import com.devansh1497.flightreservation.repository.FlightRepository;
import com.devansh1497.flightreservation.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") long flightId, ModelMap modelMap) {
		Optional<Flight> flight = flightRepository.findById(flightId);
		modelMap.addAttribute("flight",flight.get());
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequestDTO reservationRequestDTO, ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(reservationRequestDTO);
		modelMap.addAttribute("msg","Reservation created successfully! Id : "+reservation.getId());
		return "reservationConfirmation";
	}
}
