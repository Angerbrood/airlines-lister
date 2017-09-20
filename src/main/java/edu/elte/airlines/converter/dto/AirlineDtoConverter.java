package edu.elte.airlines.converter.dto;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.dto.FlightDto;

@Component
public class AirlineDtoConverter implements Converter<Airline, AirlineDto> {

	@Autowired
	private ConversionService conversionService;
	
	@Override
	public AirlineDto convert(Airline airline) {
		AirlineDto result = new AirlineDto();
		result.setId(airline.getId());
		result.setName(airline.getName());
		result.setFlights(airline.getFlights().stream().map(item -> conversionService.convert(item, FlightDto.class)).collect(Collectors.toList()));
		return result;
	}

}
