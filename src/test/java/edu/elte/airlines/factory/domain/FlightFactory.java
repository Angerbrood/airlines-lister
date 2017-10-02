package edu.elte.airlines.factory.domain;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.factory.AbstractFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FlightFactory extends AbstractFactory<Flight> {
    private LocationFactory locationFactory;
    private UserPersonalDataFactory userPersonalDataFactory;

    public FlightFactory(CrudDao<Flight, ?> dao, LocationFactory locationFactory, UserPersonalDataFactory userPersonalDataFactory) {
        super(dao);
        this.locationFactory = locationFactory;
        this.userPersonalDataFactory = userPersonalDataFactory;
    }
    @Override
    public Flight createOne(Object... arguments) {
        Faker faker = new Faker();
        Flight result = new Flight();
        result.setDestination(locationFactory.createOne());
        result.setStart(locationFactory.createOne());
        LocalDate startDate = LocalDate.of(2017,1,1);
        LocalDate endDate = LocalDate.of(2017,1,1);
        result.setStartDate(startDate);
        result.setLandingDate(endDate);
        result.setTravelTime(faker.number().randomDigit());
        result.setFlightNumber(faker.number().digits(4));
        List<UserPersonalData> passengers = new LinkedList<>();
        for(int i = 0; i < 10; ++i) {
            passengers.add(userPersonalDataFactory.createOne());
        }
        result.setPassengers(passengers);
        return result;
    }
}
