package edu.elte.airlines.controller;


import edu.elte.airlines.model.Location;

import edu.elte.airlines.response.CustomResponse;

import edu.elte.airlines.util.ServiceProvider;
import edu.elte.airlines.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LocationController {

    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/admin/addNewLocation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse addNewLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody Location location) throws IOException {
        return serviceProvider.getService(Location.class).create(location);
    }

    @RequestMapping(value = "/admin/deleteLocation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse deleteLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody Wrapper wrapper) throws IOException {
        return serviceProvider.getService(Location.class).delete(wrapper.getData());

    }
    @RequestMapping(value = "/user/listLocations", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse listLocations(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return serviceProvider.getService(Location.class).list();

    }
    @RequestMapping(value = "/admin//updateLocation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse updateLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody Location location) throws IOException {
        return serviceProvider.getService(Location.class).update(location);

    }
    @RequestMapping(value = "/admin/findLocationById", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse findLocation(HttpServletRequest request, HttpServletResponse response,
                                       @RequestBody Wrapper wrapper) throws IOException {
        return serviceProvider.getService(Location.class).findById(wrapper.getData());

    }
}
