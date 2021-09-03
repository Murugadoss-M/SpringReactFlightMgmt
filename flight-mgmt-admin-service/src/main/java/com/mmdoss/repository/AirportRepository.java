package com.mmdoss.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmdoss.document.Airport;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String>{

}
