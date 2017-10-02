package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.factory.AbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FlightDtoFactory extends AbstractFactory<FlightDto> {
    public FlightDtoFactory(CrudDao<FlightDto, ?> dao) {
        super(dao);
    }

    @Autowired
    private LocationDtoFactory locationDtoFactory;
    @Autowired
    private UserPersonalDataDtoFactory userPersonalDataDtoFactory;

    @Override
    public FlightDto createOne(Object... arguments) {
        Faker faker = new Faker();
        FlightDto result = new FlightDto();
        result.setDestination(locationDtoFactory.createOne());
        result.setStart(locationDtoFactory.createOne());
        LocalDate startDate = LocalDate.of(faker.number().randomDigit(),faker.number().randomDigit(), faker.number().randomDigit());
        LocalDate endDate = LocalDate.of(faker.number().randomDigit(),faker.number().randomDigit(), faker.number().randomDigit());
        result.setStartDate(startDate);
        result.setLandingDate(endDate);
        result.setTravelTime(faker.number().randomDigit());
        result.setFlightNumber(faker.number().digits(4));
        List<UserPersonalDataDto> passengers = new LinkedList<>();
        for(int i = 0; i < 10; ++i) {
            passengers.add(userPersonalDataDtoFactory.createOne());
        }
        result.setPassengers(passengers);
        return result;
    }
}
