package fr.equipegris.EStorymap.user;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping(value = "isAuth",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isAuth() {
    	
    	return SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser") ? false : true;
    }

} 
