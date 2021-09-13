package com.mmdoss.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmdoss.document.Flight;

public interface FlightRepository extends MongoRepository<Flight, String> {
}
