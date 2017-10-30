package edu.elte.airlines.controller;

import edu.elte.airlines.domain.Flight;
import edu.elte.airlines.dto.FlightDto;
import edu.elte.airlines.provider.ServiceProvider;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/admin/listFlights", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse listFlights(HttpServletRequest request, HttpServletResponse response) {
        return serviceProvider.getService(Flight.class).list();
    }

    @RequestMapping(value = "/admin/addFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse addFlight(HttpServletRequest request, HttpServletResponse response,
                                     @RequestBody Wrapper<FlightDto> wrapper) {
        return serviceProvider.getService(Flight.class).create(wrapper.getObject());
    }
    @RequestMapping(value = "/admin/updateFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse updateFlight(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Wrapper<FlightDto> wrapper) {
        return serviceProvider.getService(Flight.class).update(wrapper.getObject());
    }
    @RequestMapping(value = "/admin/deleteFlight", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse deleteFlight(HttpServletRequest request, HttpServletResponse response,
                                        @RequestBody Integer id) {
        return serviceProvider.getService(Flight.class).delete(id);
    }
}
