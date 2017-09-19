package edu.elte.airlines.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.elte.airlines.dao.interfaces.ILocationDao;
import edu.elte.airlines.domain.Location;

@Repository
@Transactional
public class LocationDaoImpl extends CrudDaoImpl<Location, Integer> implements ILocationDao {

	@Autowired
	public LocationDaoImpl(SessionFactory sessionFactory) {
		super(Location.class, sessionFactory);
	}

}
