package com.mmdoss.controller;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Booking;
import com.mmdoss.document.Flight;
import com.mmdoss.document.Passenger;
import com.mmdoss.repository.BookingRepository;
import com.mmdoss.repository.FlightRepository;

@RestController

@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightRepository flightRespository;

	private ArrayList<Passenger> passengers;

	private Booking booking;

	public BookingController() {
		passengers = new ArrayList<>();
	}

	@PostMapping("/get")
	@CrossOrigin(origins = "http://localhost:3000")
	public Booking getBooking() {
		return booking;
	}

	@PostMapping("/addpassenger")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Passenger> addPassenger(@RequestParam("name") String name, @RequestParam("gender") String gender,
			@RequestParam("age") String age) {
		passengers.add(new Passenger(name, gender.charAt(0), Integer.parseInt(age)));
		return passengers;
	}

	@PostMapping("/deletepassenger")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Passenger> deletePassenger(@RequestParam("index") String index) {
		passengers.remove(Integer.parseInt(index));
		return passengers;
	}

	@PostMapping(path = "/create")
	@CrossOrigin(origins = "http://localhost:3000")
	public Booking createbooking(@RequestParam("flightid") String id,@RequestParam("username")String username) {

		booking = new Booking();

		booking.setFlight_id(id);

		Optional<Flight> optional = flightRespository.findById(id);
		Flight flight = optional.get();

		booking.setDate(LocalDate.now());

		booking.setUsername(username);
		Passenger[] passenger = new Passenger[passengers.size()];
		for (int i = 0; i < passengers.size(); i++) {
			passenger[i] = passengers.get(i);
		}
		booking.setPassengers(passenger);
		booking.setPrice((passengers.size()) * flight.getCost());
		booking.setCancelled(false);
		return booking;
	}
	
	@PostMapping("/passengers")
	@CrossOrigin(origins = "http://localhost:3000")
	public Passenger[] getPassengers() {
		return booking.getPassengers();
		
	}

	@PostMapping(path = "/book")
	@CrossOrigin(origins = "http://localhost:3000")
	public String bookTicket() {
		String booking_id = bookingRepository.save(booking).getBooking_id();
		booking=new Booking();
		passengers=new ArrayList<>();
		return booking_id;
	}
	
}
