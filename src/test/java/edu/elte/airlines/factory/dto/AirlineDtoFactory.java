package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.service.interfaces.AirlineService;
import edu.elte.airlines.service.interfaces.CrudService;

import java.util.ArrayList;
import java.util.List;

public class AirlineDtoFactory extends AbstractDtoFactory<Airline, AirlineDto, Integer> {

    public AirlineDtoFactory(CrudService<Airline, AirlineDto, Integer> service, FlightDtoFactory flightDtoFactory) {
        super(service);
        this.flightDtoFactory = flightDtoFactory;

    }
    private final FlightDtoFactory flightDtoFactory;


    @Override
    public AirlineDto createOne(Object... arguments) {
        Faker faker = new Faker();
        AirlineDto result = new AirlineDto();
        result.setName(faker.name().fullName());
        List<FlightDto> flights = new ArrayList<>();
        for(int i = 0; i < 10; ++i) {
            FlightDto flightDto = flightDtoFactory.createOne();
            flights.add(flightDto);
        }
        result.setFlights(flights);
        return result;
    }
}
