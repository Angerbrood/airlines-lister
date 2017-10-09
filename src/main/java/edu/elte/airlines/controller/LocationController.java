package edu.elte.airlines.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.dto.LocationDto;
import edu.elte.airlines.provider.ServiceProvider;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.service.AdminService;
import edu.elte.airlines.service.interfaces.LocationService;
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

    @RequestMapping(value = "/addNewLocation", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public void addNewLocation(HttpServletRequest request, HttpServletResponse response, @RequestBody LocationDto locationDto) throws IOException {
        CustomResponse customResponse = serviceProvider.getService(Location.class).create(locationDto);
        System.out.println(customResponse);
    }
}
