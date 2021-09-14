package com.mmdoss.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmdoss.document.Booking;

public interface BookingRepository extends MongoRepository<Booking, String> {
	public List<Booking> findByUsername(String username);

}
