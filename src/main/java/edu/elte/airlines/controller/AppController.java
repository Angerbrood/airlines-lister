package edu.elte.airlines.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import edu.elte.airlines.model.User;
import edu.elte.airlines.response.CustomResponse;
import edu.elte.airlines.response.ResponseEnum;
import edu.elte.airlines.service.interfaces.UserService;
import edu.elte.airlines.util.AuthCredentials;
import edu.elte.airlines.util.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import edu.elte.airlines.model.UserProfile;
import edu.elte.airlines.service.interfaces.UserProfileService;
import sun.security.krb5.Credentials;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST,  consumes = "application/json", produces = "application/json")
	@CrossOrigin
	@ResponseBody
	public CustomResponse login(HttpServletRequest request, HttpServletResponse response, @RequestBody AuthCredentials credentials) {
		boolean success = userService.authenticateUser(credentials);
		if (success) {
			if(userService.isAdmin(userService.findBySSO(credentials.getUsername()))) {
				response.addCookie(new Cookie("username", credentials.getUsername()));
				response.addCookie(new Cookie("password", credentials.getPassword()));
				return new CustomResponse(ResponseEnum.SUCCESS, "Type:ADMIN", null);
			} else {
				return new CustomResponse(ResponseEnum.SUCCESS, "Type:USER", null);
			}
		} else {
			return new CustomResponse(ResponseEnum.FAILED, "Type:NONE", null);
		}
	}
}