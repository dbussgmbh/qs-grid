package de.dbuss.example.data.security;

import com.vaadin.flow.component.UI;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    public void logout(){
        UI.getCurrent().getPage().setLocation("/");
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
     //   logoutHandler.logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null,null );
    }

    public UserDetails getAuthenticatedUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return (UserDetails) context.getAuthentication().getPrincipal();
        }
        // Anonymous or no authentication.
        return null;
    }

}
