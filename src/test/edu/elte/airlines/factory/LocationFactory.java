package edu.elte.airlines.factory;


import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.Location;

public class LocationFactory extends AbstractFactory<Location> {

    public LocationFactory(CrudDao<Location, ?> dao) {
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