package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FligthDto;
import edu.elte.airlines.service.interfaces.FlightService;

public class FlightServiceImpl extends AbstractCrudServiceImpl<Flight, FligthDto, Integer> 
	implements FlightService {

	public FlightServiceImpl(FlightDao dao) {
		super(Flight.class, FligthDto.class, dao);
	}

}
