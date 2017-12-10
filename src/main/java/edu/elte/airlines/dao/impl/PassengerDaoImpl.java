package edu.elte.airlines.dao.impl;

import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.model.Passenger;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

public class PassengerDaoImpl extends AbstractDao<Integer, Passenger> implements PassengerDao {

    public PassengerDaoImpl(SessionFactory sessionFactory) {
        super(Passenger.class, sessionFactory);
    }
}
