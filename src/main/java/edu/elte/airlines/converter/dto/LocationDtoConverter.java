package edu.elte.airlines.converter.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;

@Component
public class LocationDtoConverter implements Converter<Location, LocationDto> {

	@Override
	public LocationDto convert(Location location) {
		LocationDto result = new LocationDto();
		result.setId(location.getId());
		result.setName(location.getName());
		result.setCountry(location.getCountry());
		return result;
	}

	
}
