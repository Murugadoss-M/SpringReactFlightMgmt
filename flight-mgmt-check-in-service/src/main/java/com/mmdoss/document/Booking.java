package com.mmdoss.document;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Booking")
public class Booking {

	@Id
	private String booking_id;
	private String username;
	private String flight_id;
	private LocalDate date;
	private Passenger[] passengers;
	private double price;

	public Booking() {
	}

	public Booking(String username, String flight_id, Passenger[] passengers) {
		this.username = username;
		this.flight_id = flight_id;
		this.passengers = passengers;
	}

	public String getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(String booking_id) {
		this.booking_id = booking_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Passenger[] getPassengers() {
		return passengers;
	}

	public void setPassengers(Passenger[] passengers) {
		this.passengers = passengers;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Booking [booking_id=%s, username=%s, flight_id=%s, date=%s, passengers=%s, price=%s]",
				booking_id, username, flight_id, date, Arrays.toString(passengers), price);
	}

}
