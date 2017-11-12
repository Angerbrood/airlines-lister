package edu.elte.airlines.configuration;

import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.model.*;
import edu.elte.airlines.response.CustomResponseFactory;
import edu.elte.airlines.security.SecurityConfiguration;
import edu.elte.airlines.service.impl.*;
import edu.elte.airlines.service.interfaces.*;
import edu.elte.airlines.util.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SecurityConfiguration.class})
public class ServiceConfig {
    @Autowired
    private AirlineDao airlineDao;
    @Autowired
    private FlightDao flightDao;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private PassengerDao passengerDao;
    @Autowired
    private UserProfileDao userProfileDao;
    @Autowired
    private UserDao userDao;


    @Bean
    AirlineService airlineService() {
        return new AirlineServiceImpl(airlineDao);
    }
    @Bean
    FlightService flightService() {
        return new FlightServiceImpl(flightDao, userDao);
    }
    @Bean
    LocationService locationService() {
        return new LocationServiceImpl(locationDao);
    }
    @Bean
    PassengerService passengerService() {
        return new PassengerServiceImpl(passengerDao);
    }
    @Bean
    UserProfileService userProfileService() {
        return new UserProfileServiceImpl(userProfileDao);
    }
    @Bean
    UserService userService() {
        return new UserServiceImpl(userDao, passengerDao);
    }

    @Bean
    CustomResponseFactory customResponseFactory() {
        return new CustomResponseFactory();
    }

    @Bean
    ServiceProvider serviceProvider() {
        ServiceProvider provider = new ServiceProvider(customResponseFactory());
        provider.registerService(Airline.class, airlineService());
        provider.registerService(Flight.class, flightService());
        provider.registerService(Location.class, locationService());
        provider.registerService(Passenger.class, passengerService());
        provider.registerService(UserProfile.class, userProfileService());
        provider.registerService(User.class, userService());
        return provider;
    }
}
