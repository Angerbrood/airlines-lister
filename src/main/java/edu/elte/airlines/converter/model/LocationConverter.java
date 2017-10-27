package edu.elte.airlines.converter.model;

import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter implements Converter<LocationDto, Location> {
    @Override
    public Location convert(LocationDto locationDto) {
        Location location = new Location();
        location.setCountry(locationDto.getCountry());
        location.setName(locationDto.getCity());
        location.setId(locationDto.getId());
        return location;
    }
}
