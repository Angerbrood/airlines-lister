package edu.elte.airlines.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.elte.airlines.domain.Location;
import edu.elte.airlines.domain.UserId;
import edu.elte.airlines.provider.ServiceProvider;
import edu.elte.airlines.service.interfaces.UserIdService;
import edu.elte.airlines.util.SessionWrapper;
import edu.elte.airlines.util.UserAuthUtils;
import edu.elte.airlines.util.Wrapper;
import edu.elte.airlines.util.webcontext.WebContextInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Controller
public class RootController {

	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private UserIdService userIdService;
	@Autowired
	private SessionWrapper sessionWrapper;

	@Autowired
	private ServiceProvider serviceProvider;


	private final String templateName = "login";

	@RequestMapping(value = {"/", "/login"})
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		WebContext ctx = WebContextInitializer.createContext(request, response);
		templateEngine.process(templateName, ctx, response.getWriter());
	}

	@RequestMapping("/index")
	public void auth(HttpServletRequest request, HttpServletResponse response, HttpSession session,
					 @RequestParam("username") String username, @RequestParam("password") String password) throws IOException {
		try {
			UserDetails userDetails = userIdService.authenticateUser(username, password);
			if(userDetails != null) {
				sessionWrapper.setSession(session);
				UserId userId = userIdService.getUserIdByUserName(username);
				sessionWrapper.add("userId", userId);


				WebContext ctx = WebContextInitializer.createContext(request, response);
				ctx.setVariable("username", userDetails.getUsername());
				ctx.setVariable("userLoginType", UserAuthUtils.getDefinitveRole(userDetails.getAuthorities()));
				ctx.setVariable("locationList", serviceProvider.getService(Location.class).list().getData());
				templateEngine.process("index", ctx, response.getWriter());
			}
		} catch (Exception ex) {
			loadErrorPage(request, response, ex.getMessage());
		}
	}
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
		WebContext ctx = WebContextInitializer.createContext(request, response);
		templateEngine.process("register", ctx, response.getWriter());
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logoutPage (HttpServletRequest request, HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		getLogin(request, response);
	}
	private void loadErrorPage(HttpServletRequest request, HttpServletResponse response, final String errorMessage) throws IOException {
		WebContext ctx = WebContextInitializer.createContext(request, response);
		ctx.setVariable("errorMessage", errorMessage);
		templateEngine.process("error", ctx, response.getWriter());
	}


	@RequestMapping(value = "/testEndpoint")
	public void testEndpoint(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
		Wrapper<Location> wrapper = new Wrapper<>();
		Location location = new Location();
		location.setCountry("Hungary");
		location.setName("Budapest");
		wrapper.setObject(location);
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(wrapper));
	}
}
