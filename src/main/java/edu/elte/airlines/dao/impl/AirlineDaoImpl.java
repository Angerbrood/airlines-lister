package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.IAirlineDao;
import edu.elte.airlines.domain.Airline;

@Repository
@Transactional
public class AirlineDaoImpl extends CrudDaoImpl<Airline, Integer> implements IAirlineDao {
	
	@Autowired
	public AirlineDaoImpl(SessionFactory sessionFactory) {
		super(Airline.class, sessionFactory);
	}
}
