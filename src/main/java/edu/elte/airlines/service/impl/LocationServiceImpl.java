package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.service.interfaces.LocationService;

public class LocationServiceImpl extends AbstractCrudServiceImpl<Location, LocationDto, Integer> 
	implements LocationService{

	public LocationServiceImpl(LocationDao dao) {
		super(Location.class, LocationDto.class, dao);
	}

}
