package edu.elte.airlines.controller;

import edu.elte.airlines.model.User;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.util.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/admin/listUsers", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public CustomResponse listUsers() {
        return serviceProvider.getService(User.class).list();
    }
}
