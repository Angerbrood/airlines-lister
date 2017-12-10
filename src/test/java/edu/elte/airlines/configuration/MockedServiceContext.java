package edu.elte.airlines.configuration;


import edu.elte.airlines.service.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import static org.mockito.Mockito.mock;

@Configuration
public class MockedServiceContext {
    @Bean
    AirlineService airlineService() {
        return mock(AirlineService.class);
    }
    @Bean
    FlightService flightService() {
        return mock(FlightService.class);
    }
    @Bean
    LocationService locationService() {
        return mock(LocationService.class);
    }
    @Bean
    PassengerService passengerService() {
        return mock(PassengerService.class);
    }
    @Bean
    UserProfileService userProfileService() {
        return mock(UserProfileService.class);
    }
    @Bean
    UserService userService() {
        return mock(UserService.class);
    }
}
