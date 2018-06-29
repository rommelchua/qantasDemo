package com.mel.demo.qantas.view;

import com.mel.demo.qantas.model.Airports;

import io.dropwizard.views.View;

public class AirportsView extends View {
	private Airports airports;

	public AirportsView(Airports airports) {
		super("/views/airports.mustache");
		this.airports = airports;
	}

	public Airports getAirports() {
		return airports;
	}

	public void setAirports(Airports airports) {
		this.airports = airports;
	}
}
