package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.impl.AbstractDao;
import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.model.Airline;
import edu.elte.airlines.service.interfaces.AirlineService;
import org.springframework.stereotype.Service;


public class AirlineServiceImpl extends CrudServiceImpl<Integer, Airline> implements AirlineService {

    public AirlineServiceImpl(AirlineDao dao) {
        super(dao);
    }
}
