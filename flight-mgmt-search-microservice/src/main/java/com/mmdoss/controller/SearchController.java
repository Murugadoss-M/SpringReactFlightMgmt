package com.mmdoss.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Flight;
import com.mmdoss.repository.FlightRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SearchController {

	@Autowired
	private FlightRepository flightRepository;

	@PostMapping("/search")
	public List<Flight> viewFlight(@RequestParam("date") String date, @RequestParam("from") String from,
			@RequestParam("to") String to) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// System.out.println(date);
		// System.out.println(LocalDate.parse(date, formatter));
		return flightRepository.findByDateAndFromAndTo(LocalDate.parse(date, formatter), from, to);
	}
	
}
