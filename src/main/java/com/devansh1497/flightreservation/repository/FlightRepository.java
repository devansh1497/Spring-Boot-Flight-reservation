package com.devansh1497.flightreservation.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devansh1497.flightreservation.entities.Flight;
import com.devansh1497.flightreservation.entities.User;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("select t from Flight t where t.departureCity=?1 and t.arrivalCity=?2 and t.dateOfDeparture=?3")
	List<Flight> findFlights(String from, String to, Date departureDate);

}
