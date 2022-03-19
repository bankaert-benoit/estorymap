package fr.equipegris.EStorymap.projet;

import fr.equipegris.EStorymap.user.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class ProjetController {

    @Autowired
    private ProjetRepository repo;

    @GetMapping("/createProject")
    public void createProject(@RequestParam("name") String name, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Projet p = new Projet(name, UserFactory.getCurrentUser());
        repo.save(p);
        new DefaultRedirectStrategy().sendRedirect(request,response,"/analyse?id="+p.getId());
    }

    @GetMapping("/getUserProject")
    public String getUserProject() {
        Iterable<Projet> projets = repo.getProjectByOwner(UserFactory.getCurrentUser());
        String res = "{ \"projets\": [";
        for (Projet p: projets) {
            res += "{\"nom\": \""+p.getName()+"\"},";
        }
        res = res.substring(0,res.length()-1);
        res += "]}";
        return res;
    }

    @GetMapping("/getProject")
    public String getProjectById(@RequestParam("id") Integer id){
        Projet p = repo.findProjetById(id.longValue());
        String res = "{";
        res += "\"id\" : \""+p.getId()+"\",\"name\": \""+p.getName()+"\"";
        res += "}";
        System.out.println(res);
        return res;
    }



}
