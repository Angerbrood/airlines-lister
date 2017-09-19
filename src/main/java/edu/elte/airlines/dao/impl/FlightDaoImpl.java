package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.domain.Flight;

@Repository
@Transactional
public class FlightDaoImpl extends CrudDaoImpl<Flight, Integer> implements FlightDao {

	@Autowired
	public FlightDaoImpl(SessionFactory sessionFactory) {
		super(Flight.class, sessionFactory);
	}

}
