package com.mmdoss.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmdoss.document.Flight;
@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

}
