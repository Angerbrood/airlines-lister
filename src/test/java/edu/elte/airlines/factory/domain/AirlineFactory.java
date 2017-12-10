package edu.elte.airlines.factory.domain;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.factory.AbstractFactory;


import java.util.ArrayList;
import java.util.List;

public class AirlineFactory extends AbstractFactory<Airline> {

    private FlightFactory flightFactory;

    public AirlineFactory(AirlineDao dao, FlightFactory flightFactory) {
        super(dao);
        this.flightFactory = flightFactory;
    }

    @Override
    public Airline createOne(Object... arguments) {
        Faker faker = new Faker();
        Airline result = new Airline();
        result.setName(faker.name().fullName());
        List<Flight> flights = new ArrayList<>();
        for(int i = 0; i < 10; ++i) {
            Flight flight = flightFactory.createOne();
            flights.add(flight);

        }
        result.setFlights(flights);
        return result;

    }
}
