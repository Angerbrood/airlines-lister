package edu.elte.airlines.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.provider.ServiceProvider;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.service.AdminService;
import edu.elte.airlines.service.interfaces.LocationService;
import edu.elte.airlines.util.IdWrapper;
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
    @ResponseBody
    public CustomResponse addNewLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody LocationDto locationDto) throws IOException {
        return serviceProvider.getService(Location.class).create(locationDto);
    }

    @RequestMapping(value = "/admin/deleteLocation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse deleteLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody IdWrapper idWrapper) throws IOException {
        return serviceProvider.getService(Location.class).delete(idWrapper.getId());

    }
    @RequestMapping(value = "/admin/listLocations", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse listLocations(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return serviceProvider.getService(Location.class).list();

    }
    @RequestMapping(value = "/admin/updateLocation", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse updateLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody LocationDto locationDto) throws IOException {
        return serviceProvider.getService(Location.class).update(locationDto);

    }
    @RequestMapping(value = "/admin/findLocationById", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse findLocation(HttpServletRequest request, HttpServletResponse response,
                                         @RequestBody IdWrapper idWrapper) throws IOException {
        return serviceProvider.getService(Location.class).findById(idWrapper.getId());

    }
}
