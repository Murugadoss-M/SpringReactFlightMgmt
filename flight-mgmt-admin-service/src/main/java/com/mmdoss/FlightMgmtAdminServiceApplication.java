package com.mmdoss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mmdoss.document.Airport;
import com.mmdoss.repository.AirportRepository;

@SpringBootApplication
public class FlightMgmtAdminServiceApplication implements CommandLineRunner{

	@Autowired
	AirportRepository airportRepository;
	public static void main(String[] args) {
		SpringApplication.run(FlightMgmtAdminServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		airportRepository.save(new Airport("101", "Chennai"));
		airportRepository.save(new Airport("102", "Mumbai"));
		
	}

}
