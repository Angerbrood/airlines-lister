package edu.elte.airlines.controller;

import edu.elte.airlines.converter.FlightDtoConverter;
import edu.elte.airlines.converter.ReservationDto;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.dto.SearchLocationDto;
import edu.elte.airlines.model.Flight;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.util.ServiceProvider;
import edu.elte.airlines.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FlightController {

    @Autowired
    private ServiceProvider serviceProvider;
    @Autowired
    private Converter<FlightDto, Flight> flightDtoConverter;

    @RequestMapping(value = "/user/listFlights", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse listFlights(HttpServletRequest request, HttpServletResponse response) {
        return serviceProvider.getService(Flight.class).list();
    }
    @RequestMapping(value = "/user/listReservations", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse listFlights(HttpServletRequest request, HttpServletResponse response, @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Flight.class).listReservations(wrapper.getData());

    }
    @RequestMapping(value = "/admin/addFlight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse addFlight(HttpServletRequest request, HttpServletResponse response,
                                    @RequestBody FlightDto flightDto) {
        Flight flight = flightDtoConverter.convert(flightDto);
        return serviceProvider.getService(Flight.class).createFlight(flight, flightDto.getAirlineId());
    }
    @RequestMapping(value = "/admin/updateFlight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse updateFlight(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody FlightDto flightDto) {
        Flight flight = flightDtoConverter.convert(flightDto);
        return serviceProvider.getService(Flight.class).update(flight);
    }
    @RequestMapping(value = "/admin/deleteFlight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse deleteFlight(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Flight.class).deleteFlight(wrapper.getData());
    }
    @RequestMapping(value = "/user/deleteReservation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse deleteReservation(HttpServletRequest request, HttpServletResponse response, @RequestBody ReservationDto reservationDto) {

        return serviceProvider.getService(Flight.class).removeReservation(reservationDto.getFlightId(), reservationDto.getSsoId());
    }
    @RequestMapping(value = "/user/bookFlight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse bookFlight(HttpServletRequest request, HttpServletResponse response, @RequestBody ReservationDto reservationDto) {

        return serviceProvider.getService(Flight.class).bookFlight(reservationDto.getFlightId(), reservationDto.getSsoId());
    }
    @RequestMapping(value = "/admin/findFlightById", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse findById(HttpServletRequest request, HttpServletResponse response, @RequestBody Wrapper wrapper) {

        return serviceProvider.getService(Flight.class).findById(wrapper.getData());
    }
    @RequestMapping(value = "/user/findFlightByLocations", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse findFlightByLocations(HttpServletRequest request, HttpServletResponse response, @RequestBody SearchLocationDto searchLocationDto) {

        return serviceProvider.getService(Flight.class).findBySearchLocation(searchLocationDto);
    }
}
