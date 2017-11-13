package edu.elte.airlines.controller;

import edu.elte.airlines.model.Flight;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.util.ServiceProvider;
import edu.elte.airlines.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FlightController {

    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/user/listFlights", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse listFlights(HttpServletRequest request, HttpServletResponse response) {
        return serviceProvider.getService(Flight.class).list();
    }

    @RequestMapping(value = "/admin/addFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse addFlight(HttpServletRequest request, HttpServletResponse response,
                                    @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Flight.class).create(wrapper.getData());
    }
    @RequestMapping(value = "/admin/updateFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse updateFlight(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Flight.class).update(wrapper.getData());
    }
    @RequestMapping(value = "/admin/deleteFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse deleteFlight(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(Flight.class).delete(wrapper.getData());
    }
    @RequestMapping(value = "/user/deleteReservation", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse deleteReservation(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody Wrapper wrapper) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails currentUser = (UserDetails) authentication.getDetails();
        return serviceProvider.getService(Flight.class).removeReservation(wrapper.getData(), currentUser.getUsername());
    }
    @RequestMapping(value = "/user/bookFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse bookFlight(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody Wrapper wrapper) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails currentUser = (UserDetails) authentication.getDetails();
        return serviceProvider.getService(Flight.class).bookFlight(wrapper.getData(), currentUser.getUsername());
    }

}
