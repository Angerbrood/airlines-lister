package edu.elte.airlines.dao.impl;

import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.model.Flight;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;


public class FlightDaoImpl extends AbstractDao<Integer, Flight> implements FlightDao {
    public FlightDaoImpl(SessionFactory sessionFactory) {
        super(Flight.class, sessionFactory);
    }
}
