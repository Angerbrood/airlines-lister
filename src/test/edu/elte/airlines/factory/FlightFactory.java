package edu.elte.airlines.factory;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class FlightFactory extends AbstractFactory<Flight> {

    @Autowired
    private LocationFactory locationFactory;


    public FlightFactory(CrudDao<Flight, ?> dao) {
        super(dao);
    }

    @Override
    public Flight createOne(Object... arguments) {
        Faker faker = new Faker();
        Flight result = new Flight();
        result.setDestination(locationFactory.createOne());
        result.setStart(locationFactory.createOne());
        LocalDate startDate = LocalDate.of(faker.number().randomDigit(),faker.number().randomDigit(), faker.number().randomDigit());
        LocalDate endDate = LocalDate.of(faker.number().randomDigit(),faker.number().randomDigit(), faker.number().randomDigit());
        result.setStartDate(startDate);
        result.setLandingDate(endDate);
        result.setTravelTime(faker.number().randomDigit());
        
        return result;
    }
}
