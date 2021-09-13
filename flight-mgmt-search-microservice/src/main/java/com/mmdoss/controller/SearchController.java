package com.mmdoss.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Airport;
import com.mmdoss.document.Flight;
import com.mmdoss.repository.AirportRepository;
import com.mmdoss.repository.FlightRepository;

@RestController
@RequestMapping("/search")
public class SearchController {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private AirportRepository airportRespository;

	@PostMapping("/flight")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Flight> viewFlight(@RequestParam("date") String date, @RequestParam("from") String from,
			@RequestParam("to") String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// System.out.println(date);
		// System.out.println(LocalDate.parse(date, formatter));
		return flightRepository.findByDateAndFromAndTo(LocalDate.parse(date, formatter), from, to);
	}
	@GetMapping("/airport")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Airport> getAirport(){
		return airportRespository.findAll();
	}
	@PostMapping("/id")
	@CrossOrigin(origins = "http://localhost:3000")
	public Flight getFlight(@RequestParam("id")String id) {
		System.out.println(id);
		Optional<Flight> findById = flightRepository.findById(id);
		Flight flight = findById.get();
		return flight;
	}
	
}
