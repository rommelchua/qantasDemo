package com.mel.demo.qantas;

import javax.ws.rs.client.Client;

import com.mel.demo.qantas.data.AirportDataService;
import com.mel.demo.qantas.resource.AirportsResource;

import io.dropwizard.client.JerseyClientBuilder;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class QantasDemoApplication extends Application<QantasDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new QantasDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "qantas-demo";
    }

    @Override
    public void initialize(final Bootstrap<QantasDemoConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<QantasDemoConfiguration>());
    }

    @Override
    public void run(final QantasDemoConfiguration configuration,
                    final Environment environment) {
        registerResources(environment, configuration);
    }

    public void registerResources(Environment environment, QantasDemoConfiguration configuration) {
    	final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration()).build(getName());
    	final AirportsResource airportsResource = new AirportsResource(new AirportDataService(configuration, client));
    	environment.jersey().register(airportsResource);
    }

}
