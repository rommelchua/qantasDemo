package com.mel.demo.qantas.data;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import javax.ws.rs.core.Response;

import com.mel.demo.qantas.QantasDemoConfiguration;
import com.mel.demo.qantas.model.Airports;

public class AirportDataService {
	private String QANTAS_API_URL = "http://www.qantas.com.au/api/airports";
	private Client client;

	public AirportDataService(QantasDemoConfiguration configuration, Client client) {
		this.setClient(client);
	}

	public Airports getAirportData() {
		try {
			return getData();
		} catch (Exception e) {
			return new Airports();
		}		
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	private Airports getData() {
		WebTarget target = client.target(QANTAS_API_URL);
		Builder builder = target.request();
		Response resp = builder.get();
		return resp.readEntity(Airports.class);
	}
}
