package edu.elte.airlines.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

public class SessionWrapper {
    private static Logger logger = LoggerFactory.getLogger(SessionWrapper.class);
    private HttpSession session;

    public SessionWrapper() {
    }

    public void setSession(HttpSession session) {
        if(session != null) {
            this.session = session;
        }
    }
    public void add(String key, Object value) {
        logger.info("Add key and value to session");
        if(key != null && value != null) {
            session.setAttribute(key, value);
        } else {
            if(key == null) {
                throw new IllegalArgumentException("Session key cannot be null");
            } else {
                throw new IllegalArgumentException("Session value cannot be null");
            }
        }
    }
    public Object get(String key) {
        logger.info("Request object from session");
        if(key != null) {
            return session.getAttribute(key);
        } else {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }
    public void destroy() {
        logger.info("Destroying session");
        session = null;
    }

}
