package edu.elte.airlines.factory.domain;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.factory.AbstractFactory;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class FlightFactory extends AbstractFactory<Flight> {
    private LocationFactory locationFactory;
    private PassengerFactory userPersonalDataFactory;

    public FlightFactory(FlightDao dao, LocationFactory locationFactory, PassengerFactory userPersonalDataFactory) {
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
        result.setFlightNumber("11112222");
        List<Passenger> passengers = new LinkedList<>();
        for(int i = 0; i < 10; ++i) {
            passengers.add(userPersonalDataFactory.createOne());
        }
        result.setPassengers(passengers);
        return result;
    }
}
