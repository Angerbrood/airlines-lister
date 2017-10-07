package edu.elte.airlines.controller;

import edu.elte.airlines.service.interfaces.UserIdService;
import edu.elte.airlines.util.SessionWrapper;
import edu.elte.airlines.util.webcontext.WebContextInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

@Controller
public class RootController {

	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private UserIdService userIdService;
	@Autowired
	private SessionWrapper sessionWrapper;

	private final String templateName = "login";

	@RequestMapping(value = {"/", "/login"})
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		WebContext ctx = WebContextInitializer.createContext(request, response);
		templateEngine.process(templateName, ctx, response.getWriter());
	}

	@RequestMapping("/index")
	public void auth(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String userName, HttpSession session) throws IOException {
		UserDetails userDetails = userIdService.findUserByUsername(userName);
		if(userDetails != null) {
			sessionWrapper.setSession(session);
			sessionWrapper.add("userId", userIdService.getUserIdByUserName(userName));


			WebContext ctx = WebContextInitializer.createContext(request, response);
			ctx.setVariable("username", userDetails.getUsername());
			templateEngine.process("index", ctx, response.getWriter());
		}
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public void logoutPage (HttpServletRequest request, HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		getLogin(request, response);
	}
}
