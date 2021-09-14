package com.mmdoss.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Booking;
import com.mmdoss.document.Passenger;
import com.mmdoss.repository.BookingRepository;

@RestController
@RequestMapping("/checkin")
public class CheckinController {
	
	@Autowired
	private BookingRepository bookingRepository;

	
	private Passenger[] passengers;
	
	private Booking booking;
	
	
	@PostMapping("/getbooking")
	@CrossOrigin(origins = "http://localhost:3000")
	public Booking getBooking(@RequestParam("booking_id") String id) {
		Optional<Booking> findById = bookingRepository.findById(id);
		booking = findById.get();
		return booking;
	}
	@PostMapping("/getpassengers")
	@CrossOrigin(origins = "http://localhost:3000")
	public Passenger[] cancelBooking(@RequestParam("booking_id") String id) {
		Optional<Booking> findById = bookingRepository.findById(id);
		passengers = findById.get().getPassengers();
		return passengers;
	}
	@PostMapping("/checkin")
	@CrossOrigin(origins = "http://localhost:3000")
	public Passenger[] checkinPassenger(@RequestParam("index")String index,@RequestParam("seat")String seat) {
		passengers[Integer.parseInt(index)].setSeatNo(Integer.parseInt(seat));
		passengers[Integer.parseInt(index)].setCheckedIn(true);
		return passengers;
	}

	@PostMapping(path = "/book")
	@CrossOrigin(origins = "http://localhost:3000")
	public String bookTicket() {
		booking.setPassengers(passengers);
		bookingRepository.save(booking);
		return "Success";
	}
}
