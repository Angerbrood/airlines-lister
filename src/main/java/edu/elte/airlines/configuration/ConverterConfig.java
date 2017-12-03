package edu.elte.airlines.configuration;

import edu.elte.airlines.converter.AirlineDtoConverter;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.model.Airline;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConverterConfig {
    @Bean
    Converter<AirlineDto, Airline> airlineDtoConverter() {
        return new AirlineDtoConverter();
    }
}
