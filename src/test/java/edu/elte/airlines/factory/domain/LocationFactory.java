package edu.elte.airlines.factory.domain;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.model.Location;
import edu.elte.airlines.factory.AbstractFactory;

public class LocationFactory extends AbstractFactory<Location> {

    public LocationFactory(LocationDao dao) {
        super(dao);
    }

    @Override
    public Location createOne(Object... arguments) {
        Faker faker = new Faker();
        Location result = new Location();
        result.setCountry(faker.address().country());
        result.setName(faker.address().cityName());
        return result;
    }
}
