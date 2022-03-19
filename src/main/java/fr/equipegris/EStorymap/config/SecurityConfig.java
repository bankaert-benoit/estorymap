package fr.equipegris.EStorymap.config;

import fr.equipegris.EStorymap.auth.Authentification;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.endpoint.NimbusAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configuration de l'authentification
        http.oauth2Login()
                .successHandler(successHandler())
                .tokenEndpoint().accessTokenResponseClient(accessTokenResponseClient());
        // Autre configuration
        http.cors().and().csrf().disable();
        http.headers().frameOptions().disable();
    }

    @Bean
    public Authentification successHandler(){
        return new Authentification();
    }

    private OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
        return new NimbusAuthorizationCodeTokenResponseClient();
    }

}
