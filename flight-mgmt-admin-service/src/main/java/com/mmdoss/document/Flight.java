package com.mmdoss.document;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Flight")
public class Flight {
	@Id
	private String flight_id;
	private String airways;
	private LocalDate date;
	private String from;
	private String to;
	private int seats;
	private int cost;

	public Flight() {

	}

	public Flight(String flight_id, String airways_id, LocalDate date, String from, String to, int seats, int cost) {
		super();
		this.flight_id = flight_id;
		this.airways = airways_id;
		this.date = date;
		this.from = from;
		this.to = to;
		this.seats = seats;
		this.cost = cost;
	}

	public Flight(LocalDate date, String from, String to) {
		this.date = date;
		this.from = from;
		this.to = to;
	}

	public String getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}

	public String getAirways() {
		return airways;
	}

	public void setAirways(String airways) {
		this.airways = airways;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("Flight [flight_id=%s, airways_id=%s, date=%s, from=%s, to=%s, seats=%s, cost=%s]",
				flight_id, airways, date, from, to, seats, cost);
	}

}
