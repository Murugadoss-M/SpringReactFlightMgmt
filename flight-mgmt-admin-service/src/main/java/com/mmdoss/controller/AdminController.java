package com.mmdoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Airport;
import com.mmdoss.document.Flight;
import com.mmdoss.repository.AirportRepository;
import com.mmdoss.repository.FlightRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	FlightRepository flightRepository;


	@Autowired
	AirportRepository airportRepository;

	@GetMapping("/view/flight")
	public List<Flight> viewFlights() {
		return flightRepository.findAll();
	}

	@PostMapping("/add/flight")
	public void addFlight(@RequestBody Flight flight) {
		flightRepository.save(flight);
	}

	@PostMapping("/delete/flight")
	public void deleteFlight(@RequestParam("id") String id) {
		flightRepository.deleteById(id);
	}
	
	

	@GetMapping("/view/airports")
	public List<Airport> viewAirports() {
		return airportRepository.findAll();
	}

	@PostMapping("/add/airport")
	public void addAirport(@RequestBody Airport airport) {
		airportRepository.save(airport);
	}

	@PostMapping("/delete/airport")
	public void deleteAirport(@RequestParam("id") String id) {
		airportRepository.deleteById(id);
	}
	
	
	
	
}
