package fr.equipegris.EStorymap.projet;

import fr.equipegris.EStorymap.user.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjetController {

    @Autowired
    private ProjetRepository repo;

    @PostMapping("/createProject")
    public ResponseEntity<?> createProject(@RequestParam("name") String name) {
        Projet p = new Projet(name, UserFactory.getCurrentUser());
        repo.save(p);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @GetMapping("/getProject")
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





}
