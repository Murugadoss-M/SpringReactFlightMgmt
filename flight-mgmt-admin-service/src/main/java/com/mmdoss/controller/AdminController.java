package com.mmdoss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Airport;
import com.mmdoss.document.Booking;
import com.mmdoss.document.Flight;
import com.mmdoss.repository.AirportRepository;
import com.mmdoss.repository.BookingRepository;
import com.mmdoss.repository.FlightRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FlightRepository flightRepository;


	@Autowired
	AirportRepository airportRepository;
	
	@Autowired
	private BookingRepository bookingRepository;

	@GetMapping("/view/flight")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Flight> viewFlights() {
		System.out.println("Flights");
		return flightRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add/flight")
	public void addFlight(@RequestBody Flight flight) {
		flightRepository.save(flight);
	}

	@PostMapping("/delete/flight")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteFlight(@RequestParam("id") String id) {
		flightRepository.deleteById(id);
	}
	
	

	@GetMapping("/view/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Airport> viewAirports() {
		System.out.println("Flights");
		return airportRepository.findAll();
	}

	@PostMapping("/add/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public void addAirport(@RequestBody Airport airport) {
		airportRepository.save(airport);
	}

	@PostMapping("/delete/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public void deleteAirport(@RequestParam("id") String id) {
		airportRepository.deleteById(id);
	}
	@GetMapping("/view/booking")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Booking> viewBookings() {
		System.out.println("Flights");
		return bookingRepository.findAll();
	}

	@PostMapping("/delete/booking")
	@CrossOrigin(origins = "http://localhost:3000")
	public void cancelBooking(@RequestParam("id") String id) {
		Optional<Booking> findById = bookingRepository.findById(id);
		Booking booking = findById.get();
		booking.setCancelled(true);
		bookingRepository.save(booking);
	}
	
	
	
	
}
