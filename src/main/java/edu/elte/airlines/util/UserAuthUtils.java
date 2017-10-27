package edu.elte.airlines.util;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public final class UserAuthUtils {
    private UserAuthUtils() {}

    public static String getDefinitveRole(Collection<? extends GrantedAuthority> authorities) {
        for(GrantedAuthority authority : authorities) {
            if(authority.getAuthority().equals("ADMIN")) {
                return "ADMIN";
            }
        }
        return "USER";
    }
}
