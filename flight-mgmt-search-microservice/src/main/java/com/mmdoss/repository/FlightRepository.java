package com.mmdoss.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmdoss.document.Flight;

public interface FlightRepository extends MongoRepository<Flight, String>{
	List<Flight> findByDateAndFromAndTo(LocalDate date,String from,String to);

}
