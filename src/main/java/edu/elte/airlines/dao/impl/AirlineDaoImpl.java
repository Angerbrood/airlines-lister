package edu.elte.airlines.dao.impl;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.model.Airline;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


public class AirlineDaoImpl extends AbstractDao<Integer, Airline> implements AirlineDao {

    public AirlineDaoImpl(SessionFactory sessionFactory) {
        super(Airline.class, sessionFactory);
    }
}
