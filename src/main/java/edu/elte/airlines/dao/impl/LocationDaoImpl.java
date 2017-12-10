package edu.elte.airlines.dao.impl;

import edu.elte.airlines.dao.interfaces.LocationDao;
import edu.elte.airlines.model.Location;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


public class LocationDaoImpl extends AbstractDao<Integer, Location> implements LocationDao {

    public LocationDaoImpl(SessionFactory sessionFactory) {
        super(Location.class, sessionFactory);
    }
}
