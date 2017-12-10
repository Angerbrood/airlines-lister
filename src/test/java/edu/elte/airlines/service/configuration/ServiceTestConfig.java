package edu.elte.airlines.service.configuration;

import edu.elte.airlines.configuration.MockedDaoContext;
import edu.elte.airlines.configuration.MockedServiceContext;
import edu.elte.airlines.configuration.ServiceConfig;
import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.factory.domain.*;
import edu.elte.airlines.service.impl.*;
import edu.elte.airlines.service.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MockedDaoContext.class})
public class ServiceTestConfig {
    @Bean
    PassengerFactory passengerFactory(PassengerDao passengerDao) {
        return new PassengerFactory(passengerDao);
    }
    @Bean
    LocationFactory locationFactory(LocationDao locationDao) {
        return new LocationFactory(locationDao);
    }
    @Bean
    FlightFactory flightFactory(FlightDao flightDao, LocationFactory locationFactory, PassengerFactory userPersonalDataFactory) {
        return new FlightFactory(flightDao, locationFactory, userPersonalDataFactory);
    }
    @Bean
    AirlineFactory airlineFactory(AirlineDao airlineDao, FlightFactory flightFactory) {
        return new AirlineFactory(airlineDao, flightFactory);
    }
    @Bean
    UserFactory userFactory(UserDao userDao, PassengerFactory passengerFactory, UserProfileFactory userProfileFactory) {
        return new UserFactory(userDao,userProfileFactory, passengerFactory);
    }
    @Bean
    UserProfileFactory userProfileFactory(UserProfileDao userProfileDao) {
        return new UserProfileFactory(userProfileDao);
    }


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
        return new FlightServiceImpl(flightDao, userDao, airlineDao, passengerDao);
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

}
