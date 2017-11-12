package edu.elte.airlines.dao.configuration;


import edu.elte.airlines.configuration.DaoConfig;
import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.factory.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@Import(DaoConfig.class)
public class DaoTestConfig {
    @Bean
    ConversionService conversionService() {
        return new DefaultConversionService();
    }
    @Bean
    PassengerFactory passengerFactory(PassengerDao passengerDao) {
        return new PassengerFactory(passengerDao);
    }
    @Bean
    LocationFactory locationFactory(LocationDao locationDao) {
        return new LocationFactory(locationDao);
    }
    @Bean
    FlightFactory flightFactory(FlightDao flightDao, LocationFactory locationFactory, PassengerFactory passengerFactory) {
        return new FlightFactory(flightDao, locationFactory, passengerFactory);
    }
    @Bean
    AirlineFactory airlineFactory(AirlineDao airlineDao, FlightFactory flightFactory) {
        return new AirlineFactory(airlineDao, flightFactory);
    }
    @Bean
    UserProfileFactory userProfileFactory(UserProfileDao userProfileDao) {
        return new UserProfileFactory(userProfileDao);
    }
    @Bean
    UserFactory userFactory(UserDao userDao, UserProfileFactory userProfileFactory, PassengerFactory passengerFactory) {
        return new UserFactory(userDao, userProfileFactory, passengerFactory);
    }
}
