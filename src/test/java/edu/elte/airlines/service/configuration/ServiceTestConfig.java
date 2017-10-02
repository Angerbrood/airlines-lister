package edu.elte.airlines.service.configuration;

import edu.elte.airlines.configuration.MockedDaoContext;
import edu.elte.airlines.configuration.service.ServiceConfig;
import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.factory.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceConfig.class, MockedDaoContext.class})
public class ServiceTestConfig {
    @Bean
    UserPersonalDataFactory userPersonalDataFactory(UserDetailDao userDetailDao) {
        return new UserPersonalDataFactory(userDetailDao);
    }
    @Bean
    UserAuthFactory userAuthFactory(UserAuthDao userAuthDao) {
        return new UserAuthFactory(userAuthDao);
    }
    @Bean
    LocationFactory locationFactory(LocationDao locationDao) {
        return new LocationFactory(locationDao);
    }
    @Bean
    FlightFactory flightFactory(FlightDao flightDao, LocationFactory locationFactory, UserPersonalDataFactory userPersonalDataFactory) {
        return new FlightFactory(flightDao, locationFactory, userPersonalDataFactory);
    }
    @Bean
    AirlineFactory airlineFactory(AirlineDao airlineDao, FlightFactory flightFactory) {
        return new AirlineFactory(airlineDao, flightFactory);
    }

}
