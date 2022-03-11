package fr.equipegris.EStorymap.user;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

public class UserFactory {
	
	public static User getCurrentUser() {
		DefaultOidcUser defaultOidcUser = (DefaultOidcUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return new User(defaultOidcUser.getName(),defaultOidcUser.getFullName(),defaultOidcUser.getPicture());
	}

}
