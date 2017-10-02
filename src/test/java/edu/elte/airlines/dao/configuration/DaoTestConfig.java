package edu.elte.airlines.dao.configuration;

import edu.elte.airlines.configuration.service.ServiceConfig;
import edu.elte.airlines.dao.interfaces.*;
import edu.elte.airlines.factory.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@Import(ServiceConfig.class)
public class DaoTestConfig {
    @Bean
    ConversionService conversionService() {
        return new DefaultConversionService();
    }
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
