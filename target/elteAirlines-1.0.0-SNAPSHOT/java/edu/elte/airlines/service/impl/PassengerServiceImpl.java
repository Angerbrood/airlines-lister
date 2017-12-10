package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.impl.AbstractDao;
import edu.elte.airlines.dao.interfaces.PassengerDao;
import edu.elte.airlines.model.Passenger;
import edu.elte.airlines.service.interfaces.PassengerService;
import org.springframework.stereotype.Service;


public class PassengerServiceImpl extends CrudServiceImpl<Integer, Passenger> implements PassengerService {
    public PassengerServiceImpl(PassengerDao dao) {
        super(dao);
    }
}
