package com.devansh1497.flightreservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devansh1497.flightreservation.entities.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
