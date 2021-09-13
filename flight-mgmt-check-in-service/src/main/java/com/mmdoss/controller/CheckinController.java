package com.mmdoss.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmdoss.document.Booking;
import com.mmdoss.document.Flight;
import com.mmdoss.document.Passenger;
import com.mmdoss.repository.BookingRepository;
import com.mmdoss.repository.FlightRepository;

@RestController
@RequestMapping("/checkin")
public class CheckinController {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private FlightRepository flightRespository;
	
	private ArrayList<Passenger> passengers;
	
	private Booking booking;
	
	public CheckinController() {
		passengers= new ArrayList<>();
	}
	
	
	@PostMapping("/get")
	@CrossOrigin(origins = "http://localhost:3000")
	public Booking getBooking(@RequestParam("id") String id) {
		Optional<Booking> findById = bookingRepository.findById(id);
		booking = findById.get();
		passengers=new ArrayList<Passenger>(Arrays.asList(booking.getPassengers()));
		return booking;
	}
	@PostMapping("/cancel")
	@CrossOrigin(origins = "http://localhost:3000")
	public String cancelBooking(@RequestParam("id") String id) {
		bookingRepository.deleteById(id);
		return "Success";
	}
	@PostMapping("/checkin")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<Passenger> checkinPassenger(@RequestParam("index")String index,@RequestParam("seat")String seat) {
		passengers.get(Integer.parseInt(index)).setSeatNo(Integer.parseInt(seat));
		passengers.get(Integer.parseInt(index)).setCheckedIn(true);
		return passengers;
	}

	@PostMapping(path = "/book")
	@CrossOrigin(origins = "http://localhost:3000")
	public String bookTicket(@RequestParam("flightid") String id,@RequestParam("username") String name) {

		Passenger[] passenger=new Passenger[passengers.size()];
		for(int i=0;i<passengers.size();i++) {
			passenger[i]=passengers.get(i);
		}
		booking.setPassengers(passenger);
		Booking save = bookingRepository.save(booking);
		System.out.println(save.getBooking_id());
		
		return "Success";
	}
}
