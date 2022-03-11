package fr.equipegris.EStorymap;

import fr.equipegris.EStorymap.diagramme.bpmn.*;
import fr.equipegris.EStorymap.diagramme.bpmn.Process;

//CECI EST UNE CLASSE TEST POUR VOIR SI J'ARRIVE BIEN A TOUT TRANSMETTRE DANS LA BASE DE DONNEES
public class ApplicationCreationBase {
public static void main(String[] args) throws Exception {
		
        Bpmn bpmn = new Bpmn();
        ManagerActivity ma = bpmn.getManagerActivity();
        ManagerProcess mp = bpmn.getManagerProcess();
        ManagerEvent me = bpmn.getManagerEvent();

        bpmn.debuter();

        // création de bpmn
        
        bpmn.setTitre("test");
        
        // création de process
        
        Process p_un = mp.ajouterProcess("testProcess", bpmn);
        
        // création d'events
        
        Event e_un = me.ajouterEvent("lol", p_un, false, true);

		// création d'activity
        
        Activity a_un = ma.ajouterActivity("mdr", p_un);
        
        p_un.addActivity(a_un);
        p_un.addEvent(e_un);
        
        bpmn.valider();
        
     }
}
