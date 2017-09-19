package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.IAirlineDao;
import edu.elte.airlines.dao.interfaces.ICrudDao;
import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.service.interfaces.IAirlineService;

public class AirlineServiceImpl extends AbstractCrudServiceImpl<Airline, AirlineDto, Integer>
	implements IAirlineService {

	public AirlineServiceImpl(IAirlineDao dao) {
		super(Airline.class, AirlineDto.class, dao);
	}

}
