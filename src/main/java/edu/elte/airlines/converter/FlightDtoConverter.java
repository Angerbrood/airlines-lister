package edu.elte.airlines.converter;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
@Transactional
public class FlightDtoConverter implements Converter<FlightDto, Flight> {
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private FlightDao flightDao;

    @Override
    public Flight convert(FlightDto flightDto) {
        Flight result = new Flight();
        String temp = flightDto.getId();
        if(temp != null) {
            String id = temp.split(" ")[1];
            Flight flight = flightDao.findById(Integer.parseInt(id));
            result.setPassengers(flight.getPassengers());
            result.setId(flight.getId());
        }
        result.setFlightNumber(flightDto.getNumber());
        result.setStartDate(LocalDate.parse(flightDto.getStartDate()));
        result.setLandingDate(LocalDate.parse(flightDto.getEndDate()));
        String startLocationId = flightDto.getStartLocationId();
        temp = startLocationId.split(" ")[1];
        result.setStart(locationDao.findById(Integer.parseInt(temp)));
        String endLocationId = flightDto.getEndLocationId();
        temp = endLocationId.split(" ")[1];
        result.setDestination(locationDao.findById(Integer.parseInt(temp)));
        result.setTravelTime(Integer.parseInt(flightDto.getTravelingTime()));
        return result;
    }
}
