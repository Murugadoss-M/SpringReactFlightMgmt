package com.mmdoss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Booking;
import com.mmdoss.document.Flight;
import com.mmdoss.repository.BookingRepository;
import com.mmdoss.repository.FlightRepository;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightRepository flightRespository;
	
	@PostMapping("/get")
	public List<Booking> getBooking(@RequestParam("user") String username) {
		return bookingRepository.findByUsername(username);
	}

	@PostMapping("/book")
	public String bookTicket(@RequestBody Booking temp) {

		Booking booking = new Booking();
		
		booking.setFlight_id(temp.getFlight_id());

		Optional<Flight> optional = flightRespository.findById(temp.getFlight_id());
		Flight flight = optional.get();
		
		
		booking.setDate(flight.getDate());

		booking.setUsername(temp.getUsername());
		booking.setPassengers(temp.getPassengers());
		booking.setPrice((temp.getPassengers().length) * flight.getCost());

		Booking save = bookingRepository.save(booking);
		System.out.println(save.getBooking_id());
		
		if (save != null) 
			return "success";

		return "fail";
	}
}
