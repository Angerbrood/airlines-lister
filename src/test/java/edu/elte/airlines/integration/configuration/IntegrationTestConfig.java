package edu.elte.airlines.integration.configuration;

import edu.elte.airlines.configuration.ApplicationConfig;
import edu.elte.airlines.factory.dto.*;
import edu.elte.airlines.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@Import(ApplicationConfig.class)
public class IntegrationTestConfig {
    @Autowired
    private AirlineService airlineService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private UserPersonalDataService userPersonalDataService;
    @Autowired
    private UserIdService userIdService;
    @Autowired
    private UserDetailsService userAuthService;

    @Bean
    public LocationDtoFactory locationDtoFactory() {
        return new LocationDtoFactory(locationService);
    }
    @Bean
    public UserPersonalDataDtoFactory userPersonalDataDtoFactory() {
        return new UserPersonalDataDtoFactory(userPersonalDataService);
    }
    @Bean
    public FlightDtoFactory flightDtoFactory() {
        return new FlightDtoFactory(flightService, locationDtoFactory(), userPersonalDataDtoFactory());
    }
    @Bean
    public AirlineDtoFactory airlineDtoFactory() {
        return new AirlineDtoFactory(airlineService, flightDtoFactory());
    }
    @Bean
    public UserAuthDtoFactory userAuthDtoFactory() {
        return new UserAuthDtoFactory((UserAuthService) userAuthService);
    }
    @Bean
    public UserIdDtoFactory userIdDtoFactory() {
        return new UserIdDtoFactory(userIdService, userAuthDtoFactory(), userPersonalDataDtoFactory());
    }
}
