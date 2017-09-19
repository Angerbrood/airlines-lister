package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.ICrudDao;
import edu.elte.airlines.dao.interfaces.IFlightDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FligthDto;
import edu.elte.airlines.service.interfaces.IFlightService;

public class FlightServiceImpl extends AbstractCrudServiceImpl<Flight, FligthDto, Integer> 
	implements IFlightService{

	public FlightServiceImpl(IFlightDao dao) {
		super(Flight.class, FligthDto.class, dao);
		// TODO Auto-generated constructor stub
	}

}
