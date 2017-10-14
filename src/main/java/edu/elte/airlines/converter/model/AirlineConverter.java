package edu.elte.airlines.converter.model;

import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.AirlineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AirlineConverter implements Converter<AirlineDto, Airline> {
    @Autowired
    private ConversionService conversionService;
    @Override
    public Airline convert(AirlineDto airlineDto) {
        Airline airline = new Airline();
        airline.setId(airlineDto.getId());
        airline.setFlights(airlineDto.getFlights().stream().map(item -> conversionService.convert(item, Flight.class)).collect(Collectors.toList()));
        airline.setName(airlineDto.getName());
        return airline;
    }
}
