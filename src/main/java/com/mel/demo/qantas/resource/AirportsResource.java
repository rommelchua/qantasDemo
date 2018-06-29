package com.mel.demo.qantas.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.mel.demo.qantas.data.AirportDataService;
import com.mel.demo.qantas.model.Airports;
import com.mel.demo.qantas.view.AirportsView;

import static com.mel.demo.qantas.filter.AirportsFilter.*;

@Path("/airports")
public class AirportsResource {

	private AirportDataService airportDataService;
	public AirportsResource(AirportDataService airportDataService){
		this.airportDataService = airportDataService;
	}

	@GET
	@Timed
	@Produces(MediaType.TEXT_HTML)
	public AirportsView getAirports(@DefaultValue("") @QueryParam("countryCode") String countryCode,
                                    @DefaultValue("") @QueryParam("airportCode") String airportCode,
                                    @DefaultValue("") @QueryParam("isInternational") String isInternational,
                                    @DefaultValue("") @QueryParam("isRegional") String isRegional){
		Airports airports = airportDataService.getAirportData();
		airports = filterAirportsByIsRegional(filterAirportsByIsInternational(filterAirportsByAirportCode(filterAirportsByCountryCode(airports, countryCode),airportCode),isInternational),isRegional);

		return new AirportsView(airports);
	}
}
