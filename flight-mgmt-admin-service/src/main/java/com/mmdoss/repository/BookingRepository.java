package com.mmdoss.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmdoss.document.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {

}
