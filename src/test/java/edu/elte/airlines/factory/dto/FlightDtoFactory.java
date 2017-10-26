package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.dto.UserPersonalDataDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.service.interfaces.CrudService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FlightDtoFactory extends AbstractDtoFactory<Flight, FlightDto, Integer> {


    private final LocationDtoFactory locationDtoFactory;
    private final UserPersonalDataDtoFactory userPersonalDataDtoFactory;

    public FlightDtoFactory(CrudService<Flight, FlightDto, Integer> crudService, LocationDtoFactory locationDtoFactory, UserPersonalDataDtoFactory userPersonalDataDtoFactory) {
        super(crudService);
        this.locationDtoFactory = locationDtoFactory;
        this.userPersonalDataDtoFactory = userPersonalDataDtoFactory;
    }

    @Override
    public FlightDto createOne(Object... arguments) {
        Faker faker = new Faker();
        FlightDto result = new FlightDto();
        result.setDestination(locationDtoFactory.createOne());
        result.setStart(locationDtoFactory.createOne());
        LocalDate startDate = LocalDate.of(1995,1,1);
        LocalDate endDate = LocalDate.of(1995,1,1);
        result.setStartDate(startDate);
        result.setLandingDate(endDate);
        result.setTravelTime(faker.number().randomDigit());
        result.setFlightNumber("11111122222");
        List<UserPersonalDataDto> passengers = new LinkedList<>();
        for(int i = 0; i < 10; ++i) {
            passengers.add(userPersonalDataDtoFactory.createOne());
        }
        result.setPassengers(passengers);
        return result;
    }
}
