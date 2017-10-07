package edu.elte.airlines.controller;

import edu.elte.airlines.util.webcontext.WebContextInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@Controller
public class RootController {

	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private UserDetailsService userDetailsService;

	private final String templateName = "login";

	@RequestMapping("/")
	public void getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		WebContext ctx = WebContextInitializer.createContext(request, response);
		templateEngine.process(templateName, ctx, response.getWriter());
	}

	@RequestMapping("/index")
	public void auth( HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String userName) throws IOException {
		UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
		if(userDetails != null) {
			WebContext ctx = WebContextInitializer.createContext(request, response);
			templateEngine.process("index", ctx, response.getWriter());
		}
	}
}
