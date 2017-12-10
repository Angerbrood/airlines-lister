package edu.elte.airlines.controller;

import edu.elte.airlines.converter.AirlineDtoConverter;
import edu.elte.airlines.dto.AirlineDto;
import edu.elte.airlines.model.Airline;

import edu.elte.airlines.response.CustomResponse;

import edu.elte.airlines.service.AdminService;
import edu.elte.airlines.util.ServiceProvider;
import edu.elte.airlines.util.Wrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.LinkedList;

import static edu.elte.airlines.model.UserProfileType.ADMIN;

@Controller
public class AirlineController {
    @Autowired
    private ServiceProvider serviceProvider;
    @Autowired
    private Converter<AirlineDto, Airline> airlineDtoConverter;

    @RequestMapping(value = "/user/listAirlines", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse listAirlines(HttpServletRequest request, HttpServletResponse response) {
        return serviceProvider.getService(Airline.class).list();
    }

    @RequestMapping(value = "/admin/createNewAirline", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse addAirline(HttpServletRequest request, HttpServletResponse response,
                                     @RequestBody Airline airline) {
        airline.setFlights(new LinkedList<>());
        return serviceProvider.getService(Airline.class).create(airline);
    }
    @RequestMapping(value = "/admin/updateAirline", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse updateAirline(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody AirlineDto airlineDto) {
        Airline airline = airlineDtoConverter.convert(airlineDto);
        return serviceProvider.getService(Airline.class).update(airline);
    }
    @RequestMapping(value = "/admin/deleteAirline", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse deleteAirline(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Airline.class).delete(wrapper.getData());
    }
    @RequestMapping(value = "/admin/findAirlineById", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse findById(HttpServletRequest request, HttpServletResponse response, @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Airline.class).findById(wrapper.getData());
    }
}
