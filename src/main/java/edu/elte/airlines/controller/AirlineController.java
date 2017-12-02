package edu.elte.airlines.controller;

import edu.elte.airlines.model.Airline;

import edu.elte.airlines.response.CustomResponse;

import edu.elte.airlines.util.ServiceProvider;
import edu.elte.airlines.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static edu.elte.airlines.model.UserProfileType.ADMIN;

@Controller
public class AirlineController {
    @Autowired
    private ServiceProvider serviceProvider;


    @RequestMapping(value = "/user/listAirlines", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CustomResponse listAirlines(HttpServletRequest request, HttpServletResponse response) {
        return serviceProvider.getService(Airline.class).list();
    }

    @RequestMapping(value = "/admin/createNewAirline", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse addAirline(HttpServletRequest request, HttpServletResponse response,
                                     @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Airline.class).create(wrapper.getData());
    }
    @RequestMapping(value = "/admin/updateAirline", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse updateAirline(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Airline.class).update(wrapper.getData());
    }
    @RequestMapping(value = "/deleteAirline", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse deleteAirline(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Airline.class).delete(wrapper.getData());
    }
}
