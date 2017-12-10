package edu.elte.airlines.configuration;

import edu.elte.airlines.converter.AirlineDtoConverter;
import edu.elte.airlines.converter.FlightDtoConverter;
import edu.elte.airlines.converter.UserDtoConverter;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.dto.UserDto;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfig {
    @Bean
    Converter<AirlineDto, Airline> airlineDtoConverter() {
        return new AirlineDtoConverter();
    }
    @Bean
    Converter<UserDto, User> userDtoUserConverter() {
        return new UserDtoConverter();
    }
    @Bean
    Converter<FlightDto, Flight> flightDtoFlightConverter() {
        return new FlightDtoConverter();
    }
}
