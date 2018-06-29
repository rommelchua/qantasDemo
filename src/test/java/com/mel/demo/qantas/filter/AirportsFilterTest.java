package com.mel.demo.qantas.filter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mel.demo.qantas.model.Airport;
import com.mel.demo.qantas.model.Airports;
import com.mel.demo.qantas.model.Country;

public class AirportsFilterTest {
	private Airports airports;
	//TODO: convert to Java 8 to be consistent with AirportsFilter.class which uses Java 8 
	@Before
	public void initialize() {
		airports = new Airports();
		airports.setAirports(buildAirportList());
	}

	@Test
	public void willFilterByAirportCode() {
		Airports airport = AirportsFilter.filterAirportsByAirportCode(airports, "A1");
		assertTrue(airport.getAirports().size() == 1);
		assertTrue(airport.getAirports().get(0).getCode().equals("A1"));
	}

	@Test
	public void willReturnEntireListWhenFilteredWithEmptyAirportCode() {
		Airports airport = AirportsFilter.filterAirportsByAirportCode(airports, "");
		assertTrue(airport.getAirports().size() == 4);
		airport = AirportsFilter.filterAirportsByAirportCode(airports, null);
		assertTrue(airport.getAirports().size() == 4);
	}

	@Test
	public void willReturnEmptyListIfAirportCodeIsInvalid() {
		Airports airport = AirportsFilter.filterAirportsByAirportCode(airports, "a1");
		assertTrue(airport.getAirports().size() == 0);
	}

	@Test
	public void willFilterByCountryCode() {
		Airports airport = AirportsFilter.filterAirportsByCountryCode(airports, "AU");
		assertTrue(airport.getAirports().size() == 2);
		assertTrue(airport.getAirports().get(0).getCountry().getCode().equals("AU"));
		assertTrue(airport.getAirports().get(1).getCountry().getCode().equals("AU"));

		List<String> airportCodes = new ArrayList<String>();
		airportCodes.add(airport.getAirports().get(0).getCode());
		airportCodes.add(airport.getAirports().get(1).getCode());

		assertTrue(airportCodes.contains("A1"));
		assertTrue(airportCodes.contains("A2"));
	}

	@Test
	public void willReturnEntireListWhenFilteredWithEmptyCountryCode() {
		Airports airport = AirportsFilter.filterAirportsByCountryCode(airports, "");
		assertTrue(airport.getAirports().size() == 4);
		airport = AirportsFilter.filterAirportsByCountryCode(airports, null);
		assertTrue(airport.getAirports().size() == 4);
	}

	@Test
	public void willReturnEmptyListIfCountryCodeIsInvalid() {
		Airports airport = AirportsFilter.filterAirportsByCountryCode(airports, "AZ");
		assertTrue(airport.getAirports().size() == 0);
	}
	
	@Test
	public void willFilterByIsInternational() {
		Airports airport = AirportsFilter.filterAirportsByIsInternational(airports, "true");
		assertTrue(airport.getAirports().size() == 1);
		assertTrue(airport.getAirports().get(0).getCode().equals("A1"));

		airport = AirportsFilter.filterAirportsByIsInternational(airports, "false");
		assertTrue(airport.getAirports().size() == 3);

		List<String> airportCodes = new ArrayList<String>();
		airportCodes.add(airport.getAirports().get(0).getCode());
		airportCodes.add(airport.getAirports().get(1).getCode());
		airportCodes.add(airport.getAirports().get(2).getCode());
		
		assertTrue(airportCodes.contains("A2"));
		assertTrue(airportCodes.contains("A3"));
		assertTrue(airportCodes.contains("A4"));

		airport = AirportsFilter.filterAirportsByIsInternational(airports, "invalid");
		assertTrue(airport.getAirports().size() == 3);

        airportCodes = new ArrayList<String>();
		airportCodes.add(airport.getAirports().get(0).getCode());
		airportCodes.add(airport.getAirports().get(1).getCode());
		airportCodes.add(airport.getAirports().get(2).getCode());
		
		assertTrue(airportCodes.contains("A2"));
		assertTrue(airportCodes.contains("A3"));
		assertTrue(airportCodes.contains("A4"));
	}

	@Test
	public void willReturnEntireListIfIsInternationalIsEmpty() {
		Airports airport = AirportsFilter.filterAirportsByIsInternational(airports, "");
		assertTrue(airport.getAirports().size() == 4);
	}

	@Test
	public void willFilterByIsRegional() {
		Airports airport = AirportsFilter.filterAirportsByIsRegional(airports, "true");
		assertTrue(airport.getAirports().size() == 1);
		assertTrue(airport.getAirports().get(0).getCode().equals("A4"));

		airport = AirportsFilter.filterAirportsByIsRegional(airports, "false");
		assertTrue(airport.getAirports().size() == 3);

		List<String> airportCodes = new ArrayList<String>();
		airportCodes.add(airport.getAirports().get(0).getCode());
		airportCodes.add(airport.getAirports().get(1).getCode());
		airportCodes.add(airport.getAirports().get(2).getCode());
		
		assertTrue(airportCodes.contains("A1"));
		assertTrue(airportCodes.contains("A2"));
		assertTrue(airportCodes.contains("A3"));

		airport = AirportsFilter.filterAirportsByIsRegional(airports, "invalid");
		assertTrue(airport.getAirports().size() == 3);

        airportCodes = new ArrayList<String>();
		airportCodes.add(airport.getAirports().get(0).getCode());
		airportCodes.add(airport.getAirports().get(1).getCode());
		airportCodes.add(airport.getAirports().get(2).getCode());
		
		assertTrue(airportCodes.contains("A1"));
		assertTrue(airportCodes.contains("A2"));
		assertTrue(airportCodes.contains("A3"));
	}

	@Test
	public void willReturnEntireListIfIsRegionalIsEmpty() {
		Airports airport = AirportsFilter.filterAirportsByIsRegional(airports, "");
		assertTrue(airport.getAirports().size() == 4);
	}

	private List<Airport> buildAirportList() {
		Country c1 = new Country();
		c1.setCode("AU");
		c1.setDisplayName("Australia");

		Country c2 = new Country();
		c2.setCode("CH");
		c2.setDisplayName("China");

		Airport a1 = new Airport();
		a1.setCode("A1");
		a1.setCountry(c1);
		a1.setInternationalAirport(true);
		a1.setRegionalAirport(false);

		Airport a2 = new Airport();
		a2.setCode("A2");
		a2.setCountry(c1);
		a2.setInternationalAirport(false);
		a2.setRegionalAirport(false);

		Airport a3 = new Airport();
		a3.setCode("A3");
		a3.setCountry(c2);
		a3.setInternationalAirport(false);
		a3.setRegionalAirport(false);
		
		Airport a4 = new Airport();
		a4.setCode("A4");
		a4.setCountry(c2);
		a4.setInternationalAirport(false);
		a4.setRegionalAirport(true);

		return Arrays.asList(new Airport[]{a1,a2,a3,a4});
	}
}
