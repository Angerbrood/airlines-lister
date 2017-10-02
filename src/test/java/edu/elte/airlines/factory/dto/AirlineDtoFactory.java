package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.factory.AbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AirlineDtoFactory extends AbstractFactory<AirlineDto> {
    public AirlineDtoFactory(CrudDao<AirlineDto, ?> dao) {
        super(dao);
    }

    @Autowired
    private FlightDtoFactory flightDtoFactory;

    @Override
    public AirlineDto createOne(Object... arguments) {
        Faker faker = new Faker();
        AirlineDto result = new AirlineDto();
        result.setName(faker.name().fullName());
        List<FlightDto> flights = new ArrayList<>();
        for(int i = 0; i < 10; ++i) {
            flights.add(flightDtoFactory.createOne());
        }
        result.setFlights(flights);
        return result;
    }
}
