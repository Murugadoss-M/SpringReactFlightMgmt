package com.mmdoss.repository;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmdoss.document.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String>{
	List<Flight> findByDateAndFromAndTo(LocalDate date,String from,String to);

}
