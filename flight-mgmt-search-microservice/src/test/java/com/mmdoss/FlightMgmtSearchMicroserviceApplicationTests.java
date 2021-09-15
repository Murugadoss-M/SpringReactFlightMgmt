package com.mmdoss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mmdoss.controller.SearchController;
import com.mmdoss.document.Airport;
import com.mmdoss.repository.AirportRepository;
import com.mmdoss.repository.FlightRepository;

@SpringBootTest
class FlightMgmtSearchMicroserviceApplicationTests {
	
	@Mock
	private FlightRepository flightRepository;
	
	@Mock
	private AirportRepository airportRepository;
		
	
	
	
	@Test
	void testFlights() {
		when(flightRepository.count()).thenReturn(4L);
		assertEquals(flightRepository.count(), 4L);
		
	}
	
	@Test
	void testAirports() {
		when(airportRepository.count()).thenReturn(4L);
		assertEquals(airportRepository.count(), 4L);
		
	}
	
	@Test
	void testControllerSearch() {
		List<Airport> value=new ArrayList<Airport>();
		when(airportRepository.findAll()).thenReturn(value);
		assertEquals(airportRepository.findAll(), value);
	}
	
	

}
