package edu.elte.airlines.converter.model;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FlightConverter implements Converter<FlightDto, Flight> {

    @Autowired
    private ConversionService conversionService;
    @Autowired
    private AirlineDao airlineDao;

    @Override
    public Flight convert(FlightDto flightDto) {
        Flight flight = new Flight();
        flight.setId(flightDto.getId());
        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setTravelTime(flightDto.getTravelTime());
        flight.setLandingDate(flightDto.getLandingDate());
        flight.setStartDate(flightDto.getStartDate());
        flight.setDestination(conversionService.convert(flightDto.getDestination(), Location.class));
        flight.setAirline(airlineDao.findById(flightDto.getAirlineId()));
        flight.setStart(conversionService.convert(flightDto.getStart(), Location.class));
        flight.setPassengers(flightDto.getPassengers().stream().map(item -> conversionService.convert(item, UserPersonalData.class)).collect(Collectors.toList()));
        return flight;
    }
}
