package edu.elte.airlines.service;

import edu.elte.airlines.dao.interfaces.CrudDao;
import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.factory.domain.LocationFactory;
import edu.elte.airlines.service.configuration.ServiceTestConfig;
import edu.elte.airlines.service.interfaces.CrudService;
import edu.elte.airlines.service.interfaces.LocationService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ServiceTestConfig.class})
@Transactional
@Rollback(false)
public class LocationServiceTest extends AbstractServiceTest<Location, LocationDto> {

    @Autowired
    private LocationService locationService;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private ConversionService conversionService;
    @Autowired
    private LocationFactory locationFactory;

    @Override
    protected CrudService<Location, LocationDto, Integer> getService() {
        return locationService;
    }

    @Override
    protected CrudDao<Location, Integer> getDao() {
        return locationDao;
    }

    @Override
    protected ConversionService getConversionService() {
        return conversionService;
    }

    @Override
    protected Class<Location> getEntityClass() {
        return Location.class;
    }

    @Override
    protected Location createEntity(boolean withId) {
        Location location = locationFactory.createOne();
        if(withId) {
            location.setId(1);
        }
        return location;
    }

    @Override
    protected LocationDto createDto() {
        return new LocationDto();
    }
}
