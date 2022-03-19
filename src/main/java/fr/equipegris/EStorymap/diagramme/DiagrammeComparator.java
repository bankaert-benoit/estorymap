 package fr.equipegris.EStorymap.diagramme;

import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import fr.equipegris.EStorymap.diagramme.bpmn.Event;
import fr.equipegris.EStorymap.diagramme.bpmn.Bpmn;
import fr.equipegris.EStorymap.diagramme.bpmn.Process;
import fr.equipegris.EStorymap.diagramme.mcd.Entity;
import fr.equipegris.EStorymap.diagramme.mcd.Mcd;
import fr.equipegris.EStorymap.diagramme.mfc.Mfc;
import fr.equipegris.EStorymap.diagramme.mfc.composant.Flux;

/**
 * 
 * Cette classe sert à comparer des diagrammes
 *
 */

public class DiagrammeComparator {
    
    private Mfc m_Mfc;
    private Mcd m_Mcd;
    private Bpmn m_Bpmn;
    
    
    /**
     * 
     * @param mfc 
     * @param mcd
     * @param bpmn
     */
    public DiagrammeComparator(Mfc mfc, Mcd mcd, Bpmn bpmn) {
    	this.m_Mfc = mfc;
    	this.m_Mcd = mcd;
    	this.m_Bpmn = bpmn;
    	System.out.println(this.m_Bpmn.toString());
    }
    
    /**
     * Compare the diagrammes. Implementation of compareActors() and compareFlux()
     * @return <true> if same acteurs and flux. 
     *            <false> otherwise 
     */
    public boolean compare() {
        if (this.compareFlux()) {
            return true;
        }else {
            return false;
        }
        
    }
    
    /**
     * Compare flux of bpmn and mfc
     * @return
     */
    public boolean compareFlux() {
    	Set<Event> bpmnFlux = this.getEventFromAllProcessInBpmn();
    	Set<Flux> mfcFlux = this.m_Mfc.getFlux();
    	//comparaison des nom des flux
    	List<String> eventsNameBPMN = this.getNamesOfBpmnEvents(bpmnFlux);
    	System.out.println("EVENT NAME BPMN");
    	for(String s : eventsNameBPMN) {
    		System.out.println(s);
		}
		System.out.println("COMPARE FLUX");
    	for (Flux f : mfcFlux) {
    		System.out.println(f.getLibelle());
			System.out.println(eventsNameBPMN.contains(f.getLibelle()));
    		if (!eventsNameBPMN.contains(f.getLibelle())) {
    			return false;
    		}
    	}
        return true;
    }
    
    /**
     * Compare actors of bpmn and mcd
     * @return
     */
    public boolean compareActors() {
    	Set<Process> piscines = this.m_Bpmn.getProcess();
    	//liste des acteurs du bpmn
    	List<String> actors = new ArrayList<String>();
    	for(Process p: piscines) {
    		actors.add(p.getParticipant());
    	}
    	Set<Entity> entities = this.m_Mcd.getProcess();
    	for(Entity e : entities) {
    		if(!actors.contains(e.getName())) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    
    /**
     * Get names of all bpmn events
     * @param events
     * @return names of bpmn events
     */
    private List<String> getNamesOfBpmnEvents(Set<Event> events){
    	List<String> bpmnFluxName = new ArrayList<String>();
    	for (Event e: events) {
    		bpmnFluxName.add(e.getName());
    	}
    	return bpmnFluxName;
    }
    
    
    /**
     * Get all events in all process in bpmn
     * @return all events
     */
    private Set<Event> getEventFromAllProcessInBpmn(){
    	Set<Event> events = new HashSet<Event>();
    	Set<Process> piscines = this.m_Bpmn.getProcess();
    	for (Process piscine : piscines) { //toutes les piscines
    		Set<Event> subEvents = piscine.getEvent();
    		events.addAll(subEvents);
    	}
    	return events;
    }
    
    
    private List<String> getNamesOfBpmnFlux(){
    	Set<Event> bpmnFlux = this.getEventFromAllProcessInBpmn();
    	//recuperer la liste des noms des flux
    	List<String> bpmnFluxName = new ArrayList<String>();
    	for (Event e: bpmnFlux) {
    		bpmnFluxName.add(e.getName());
    	}
    	return bpmnFluxName;
    }    

}
