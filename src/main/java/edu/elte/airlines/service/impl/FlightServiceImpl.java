package edu.elte.airlines.service.impl;

import edu.elte.airlines.dao.interfaces.FlightDao;
import edu.elte.airlines.dao.interfaces.UserIdDao;
import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.service.interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class FlightServiceImpl extends AbstractCrudServiceImpl<Flight, FlightDto, Integer> 
	implements FlightService {

	public FlightServiceImpl(FlightDao dao) {
		super(Flight.class, FlightDto.class, dao);
	}

	@Autowired
	private UserIdDao userIdDao;
	@Autowired
	private FlightDao flightDao;

	@Override
	public void bookFlight(Integer userId, Integer flightId) {
		Objects.requireNonNull(userId);
		Objects.requireNonNull(flightId);
		UserId selectedUser = userIdDao.findById(userId);
		Flight flight = flightDao.findById(flightId);
		flight.addPassenger(selectedUser.getUserPersonalData());
	}
}
