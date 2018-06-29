package com.mel.demo.qantas.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.mel.demo.qantas.model.Airport;
import com.mel.demo.qantas.model.Airports;

public class AirportsFilter {
	public static Airports filterAirportsByCountryCode(Airports airports, String countryCode) {
		if (StringUtils.isEmpty(countryCode)) return airports;
		List<Airport> airportsList = airports.getAirports();
		Airports filteredAirports = new Airports();
		filteredAirports.setAirports(airportsList.stream().filter(airport -> countryCode.equals((airport.getCountry() != null)? airport.getCountry().getCode():"")).collect(Collectors.toList()));
		return filteredAirports;
	}

	public static Airports filterAirportsByAirportCode(Airports airports, String airportCode) {
		if (StringUtils.isEmpty(airportCode)) return airports;
		List<Airport> airportsList = airports.getAirports();
		Airports filteredAirports = new Airports();
		filteredAirports.setAirports(airportsList.stream().filter(airport -> airportCode.equals(airport.getCode())).collect(Collectors.toList()));
		return filteredAirports;
	}

	public static Airports filterAirportsByIsInternational(Airports airports, String isInternational) {
		if (StringUtils.isEmpty(isInternational)) return airports;
		List<Airport> airportsList = airports.getAirports();
		Boolean bool = new Boolean(isInternational);
		Airports filteredAirports = new Airports();
		filteredAirports.setAirports(airportsList.stream().filter(airport -> bool.equals(airport.isInternationalAirport())).collect(Collectors.toList()));
		return filteredAirports;
	}

	public static Airports filterAirportsByIsRegional(Airports airports, String isRegional) {
		if (StringUtils.isEmpty(isRegional)) return airports;
		List<Airport> airportsList = airports.getAirports();
		Boolean bool = new Boolean(isRegional);
		Airports filteredAirports = new Airports();
		filteredAirports.setAirports(airportsList.stream().filter(airport -> bool.equals(airport.isRegionalAirport())).collect(Collectors.toList()));
		return filteredAirports;
	}
}
