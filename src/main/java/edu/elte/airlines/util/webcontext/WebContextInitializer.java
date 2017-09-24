package edu.elte.airlines.util.webcontext;

import org.thymeleaf.context.WebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class WebContextInitializer {
    private WebContextInitializer() {

    }


    public static WebContext createContext(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        return new WebContext(request, response, request.getServletContext(), request.getLocale());

    }

}
