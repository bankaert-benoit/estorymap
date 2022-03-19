package fr.equipegris.EStorymap.diagramme;

import fr.equipegris.EStorymap.projet.Projet;
import fr.equipegris.EStorymap.projet.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DiagrammeController {

    @Autowired
    private ProjetRepository repo;

    @GetMapping("/compare")
    public void compareProjet(@RequestParam("id") Integer id, HttpServletResponse response, HttpServletRequest request) throws IOException {
        Projet p = repo.findProjetById(id.longValue());
        System.out.println(p.getBpmn().toString());
        DiagrammeComparator dc = new DiagrammeComparator(p.getMfc(),p.getMcd(), p.getBpmn());
        System.out.println(id);
        System.out.println(dc.compare());
        new DefaultRedirectStrategy().sendRedirect(request,response,"/result?success="+dc.compare());
    }
}
