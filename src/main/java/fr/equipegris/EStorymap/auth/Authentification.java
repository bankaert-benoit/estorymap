package fr.equipegris.EStorymap.auth;

import fr.equipegris.EStorymap.user.User;
import fr.equipegris.EStorymap.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class Authentification {

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;
    @Autowired
    private UserRepository repo;

    @GetMapping("/loginSuccess")
    public String getLoginInfo(Model model, OAuth2AuthenticationToken authentification) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentification.getAuthorizedClientRegistrationId(),
                authentification.getName()
        );

        String userInfoEndpointUri = client.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUri();
        if (!StringUtils.isEmpty(userInfoEndpointUri)) {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
            HttpEntity entity = new HttpEntity("", headers);
            ResponseEntity<Map> response = restTemplate
                    .exchange(userInfoEndpointUri, HttpMethod.GET, entity, Map.class);
            Map userAttributes = response.getBody();
            model.addAttribute("name", userAttributes.get("name"));
            model.addAttribute("picture",userAttributes.get("picture"));
        }
        User user = new User(authentification.getName(),model.getAttribute("name").toString(),model.getAttribute("picture").toString());

        checkUserIfExist(user);

        return user.toString();
    }


    public void checkUserIfExist(User user){
        if (repo.findbyId(user.getId()) == null) {
            repo.save(user);
        }
    }

}
