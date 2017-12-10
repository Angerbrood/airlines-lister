package edu.elte.airlines.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.elte.airlines.converter.UserDtoConverter;
import edu.elte.airlines.dto.UserDto;
import edu.elte.airlines.model.User;
import edu.elte.airlines.model.UserProfile;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.response.ResponseEnum;
import edu.elte.airlines.util.ServiceProvider;
import edu.elte.airlines.util.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Transactional
public class UserController {
    @Autowired
    private ServiceProvider serviceProvider;
    @Autowired
    private Converter<UserDto, User> userDtoConverter;

    @RequestMapping(value = "/admin/listUserRoles", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse listUserRoles() {
        return serviceProvider.getService(UserProfile.class).list();
    }

    @RequestMapping(value = "/admin/listUsers", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse listUsers(HttpServletRequest request, HttpServletResponse response) {
        return serviceProvider.getService(User.class).fetchUsers();

    }
    @RequestMapping(value = "/admin/createNewUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse createUser(@RequestBody UserDto userDto) {
        User user = userDtoConverter.convert(userDto);
        return serviceProvider.getService(User.class).create(user);
    }
    @RequestMapping(value = "/admin/updateNewUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse updateUser(@RequestBody UserDto userDto) {
        User user = userDtoConverter.convert(userDto);
        return serviceProvider.getService(User.class).updateUser(user);
    }
    @RequestMapping(value = "/admin/deleteUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse deleteUser(@RequestBody Wrapper wrapper) {
        return serviceProvider.getService(User.class).delete(wrapper.getData());
    }
    @RequestMapping(value = "/user/getPersonalData", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse getPersonalData(@RequestBody Wrapper wrapper) {
        return serviceProvider.getService(User.class).getPersonalData(wrapper.getData());
    }
    @RequestMapping(value = "/user/modifyPersonalData", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse modifyPersonalData(@RequestBody UserDto userDto) {
        User user = userDtoConverter.convert(userDto);
        return serviceProvider.getService(User.class).modifyPersonalData(user);
    }
    @RequestMapping(value = "/admin/findUserById", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse findById(@RequestBody Wrapper wrapper) {
        return serviceProvider.getService(User.class).findById(wrapper.getData());
    }
    @RequestMapping(value = "/user/logout", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse logout(HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(new Cookie("username", null));
        response.addCookie(new Cookie("password", null));
        return new CustomResponse(ResponseEnum.SUCCESS, null, "Logout success");
    }
    @RequestMapping(value = "/user/getUserPermission", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @CrossOrigin
    @ResponseBody
    public CustomResponse getUserPermision(HttpServletRequest request, HttpServletResponse response, @RequestBody Wrapper wrapper) {
        return serviceProvider.getService(User.class).getUserPermission(wrapper.getData());
    }
}
