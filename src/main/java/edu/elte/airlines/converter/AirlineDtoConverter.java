package edu.elte.airlines.converter;

import edu.elte.airlines.dao.interfaces.AirlineDao;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.model.Airline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AirlineDtoConverter implements Converter<AirlineDto, Airline> {

    @Autowired
    private AirlineDao airlineDao;

    @Override
    public Airline convert(AirlineDto airlineDto) {
        Airline result = new Airline();
        result.setName(airlineDto.getName());
        String id = airlineDto.getId();
        result.setId(Integer.parseInt(id));
        result.setFlights(airlineDao.findById(result.getId()).getFlights());
        return result;
    }
}
