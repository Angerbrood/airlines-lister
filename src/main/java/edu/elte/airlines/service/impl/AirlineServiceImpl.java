package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.domain.Airline;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.service.interfaces.AirlineService;

public class AirlineServiceImpl extends AbstractCrudServiceImpl<Airline, AirlineDto, Integer>
	implements AirlineService {

	public AirlineServiceImpl(AirlineDao dao) {
		super(Airline.class, AirlineDto.class, dao);
	}

}
