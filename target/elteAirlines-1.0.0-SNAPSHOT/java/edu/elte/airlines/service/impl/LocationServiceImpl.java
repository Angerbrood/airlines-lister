package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.impl.AbstractDao;
import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.model.Location;
import edu.elte.airlines.service.interfaces.LocationService;
import org.springframework.stereotype.Service;


public class LocationServiceImpl extends CrudServiceImpl<Integer, Location> implements LocationService {
    public LocationServiceImpl(LocationDao dao) {
        super(dao);
    }
}
