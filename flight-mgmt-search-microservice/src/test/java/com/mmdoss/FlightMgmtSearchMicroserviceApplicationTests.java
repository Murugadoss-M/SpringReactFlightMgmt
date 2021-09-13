package com.mmdoss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mmdoss.document.Flight;
import com.mmdoss.repository.AirportRepository;
import com.mmdoss.repository.FlightRepository;

@SpringBootTest
class FlightMgmtSearchMicroserviceApplicationTests {
	
	@Mock
	private FlightRepository flightRepository;
	
	@Mock
	private AirportRepository airportRepository;
		
	
	@Test
	void contextLoads() {
		assertTrue(true);
	}
	
	@Test
	void testFlights() {
		when(flightRepository.count()).thenReturn(Long.parseLong("4"));
		assertEquals(flightRepository.count(), 4L);
		
	}
	
	@Test
	void testAirports() {
		when(airportRepository.count()).thenReturn(Long.parseLong("4"));
		assertEquals(airportRepository.count(), 4L);
		
	}
	
	
	

}
