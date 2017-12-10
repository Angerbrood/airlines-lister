package edu.elte.airlines.integration.configuration;

import edu.elte.airlines.configuration.ApplicationConfig;
import edu.elte.airlines.dao.configuration.DaoTestConfig;
import edu.elte.airlines.service.interfaces.AirlineService;
import edu.elte.airlines.service.interfaces.FlightService;
import edu.elte.airlines.service.interfaces.LocationService;
import edu.elte.airlines.service.interfaces.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ApplicationConfig.class)
public class IntegrationTestConfig {


}
