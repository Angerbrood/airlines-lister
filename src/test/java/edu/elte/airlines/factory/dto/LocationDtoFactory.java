package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.factory.AbstractFactory;

public class LocationDtoFactory extends AbstractFactory<LocationDto> {
    public LocationDtoFactory(CrudDao<LocationDto, ?> dao) {
        super(dao);
    }

    @Override
    public LocationDto createOne(Object... arguments) {
        Faker faker = new Faker();
        LocationDto result = new LocationDto();
        result.setCountry(faker.address().country());
        result.setName(faker.address().cityName());
        return result;
    }
}
