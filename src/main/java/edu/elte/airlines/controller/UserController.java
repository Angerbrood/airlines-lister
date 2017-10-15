package edu.elte.airlines.controller;

import edu.elte.airlines.domain.UserAuth;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.domain.UserPersonalData;
import edu.elte.airlines.dto.UserAuthDto;
import edu.elte.airlines.dto.UserIdDto;
import edu.elte.airlines.dto.UserPersonalDataDto;
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
public class UserController {
    @Autowired
    private ServiceProvider serviceProvider;


    @RequestMapping(value = "/user/modifyAuthData", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse modifyAuthData(HttpServletRequest request, HttpServletResponse response,
                                             @RequestBody Wrapper<UserAuthDto> wrapper) {
        return serviceProvider.getService(UserAuth.class).update(wrapper.getObject());
    }

    @RequestMapping(value = "/user/modifyPersonalData", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse modifyPersonalData(HttpServletRequest request, HttpServletResponse response,
                                             @RequestBody Wrapper<UserPersonalDataDto> wrapper) {
        return serviceProvider.getService(UserPersonalData.class).update(wrapper.getObject());
    }

    @RequestMapping(value = "/registerNewUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public CustomResponse registerNewUser(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody Wrapper<UserIdDto> wrapper) {
        return serviceProvider.getService(UserId.class).createNewUser(wrapper.getObject());

    }


}
