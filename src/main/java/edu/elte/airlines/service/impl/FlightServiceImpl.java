package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.service.interfaces.FlightService;

public class FlightServiceImpl extends AbstractCrudServiceImpl<Flight, FlightDto, Integer> 
	implements FlightService {

	public FlightServiceImpl(FlightDao dao) {
		super(Flight.class, FlightDto.class, dao);
	}

}
