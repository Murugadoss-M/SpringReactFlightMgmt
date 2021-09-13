package com.mmdoss.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		return flightRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/add/flight")
	public List<Flight> addFlight(@RequestParam("id")String id,@RequestParam("airways")String airways,
			@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("date")String date,
			@RequestParam("seats")String seat,@RequestParam("cost")String cost) {
		
		Flight flight=new Flight();
		
		flight.setFlight_id(id);
		flight.setAirways(airways);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		flight.setDate(LocalDate.parse(date, formatter));
		
		flight.setFrom(from);
		flight.setTo(to);
		
		flight.setSeats(Integer.parseInt(seat));
		flight.setCost(Integer.parseInt(cost));
		
		
		flightRepository.save(flight);
		return viewFlights();
	}

	@PostMapping("/delete/flight")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Flight> deleteFlight(@RequestParam("id") String id) {
		flightRepository.deleteById(id);
		return viewFlights();
	}

	@GetMapping("/view/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Airport> viewAirports() {
		return airportRepository.findAll();
	}

	@PostMapping("/add/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Airport> addAirport(@RequestParam("id") String id, @RequestParam("city") String city) {
		airportRepository.save(new Airport(id, city));
		return viewAirports();
	}

	@PostMapping("/delete/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Airport> deleteAirport(@RequestParam("id") String id) {
		airportRepository.deleteById(id);
		return viewAirports();
	}

	@GetMapping("/view/booking")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Booking> viewBookings() {
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
