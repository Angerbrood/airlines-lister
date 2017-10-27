package edu.elte.airlines.factory.dto;

import com.github.javafaker.Faker;
import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.factory.AbstractDtoFactory;
import edu.elte.airlines.factory.AbstractFactory;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.LocationService;

public class LocationDtoFactory extends AbstractDtoFactory<Location, LocationDto, Integer> {


    public LocationDtoFactory(CrudService<Location, LocationDto, Integer> crudService) {
        super(crudService);
    }


    @Override
    public LocationDto createOne(Object... arguments) {
        Faker faker = new Faker();
        LocationDto result = new LocationDto();
        result.setCountry(faker.address().country());
        result.setCity(faker.address().cityName());
        return result;
    }

    public LocationDto createAndSave(Object... arg) {
        LocationDto result = createOne();
        result.setId(getService().create(result));
        return result;
    }
}
