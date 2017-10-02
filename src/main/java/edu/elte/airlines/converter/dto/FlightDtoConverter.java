package edu.elte.airlines.converter.dto;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.dto.UserPersonalDataDto;

@Component
public class FlightDtoConverter implements Converter<Flight, FlightDto> {

	@Autowired
	private ConversionService conversionService;
	
	
	@Override
	public FlightDto convert(Flight flight) {
		FlightDto result = new FlightDto();
		result.setId(flight.getId());
		result.setFlightNumber(flight.getFlightNumber());
		result.setLandingDate(flight.getLandingDate());
		result.setStartDate(flight.getStartDate());
		result.setTravelTime(flight.getTravelTime());
		result.setStart(conversionService.convert(flight.getStart(), LocationDto.class));
		result.setDestination(conversionService.convert(flight.getDestination(), LocationDto.class));
		result.setPassengers(flight.getPassengers().stream().map(item -> conversionService.convert(item, UserPersonalDataDto.class)).collect(Collectors.toList()));
		return result;
	}

}
