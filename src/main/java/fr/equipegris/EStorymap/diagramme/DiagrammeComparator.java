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
    }
    
    /**
     * Compare the diagrammes. Implementation of compareActors() and compareFlux()
     * @return <true> if same acteurs and flux. 
     *            <false> otherwise 
     */
    public boolean compare() {
        if (this.compareFlux() && this.compareActors()) {
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
    	if (bpmnFlux.size() != mfcFlux.size()) {
    		return false;
    	}
    	//comparaison des nom des flux
    	List<String> eventsNameBPMN = this.getNamesOfBpmnEvents(bpmnFlux);
    	for (Flux f : mfcFlux) {
    		if (!eventsNameBPMN.contains(f.getName())) {
    			return false;
    		}
    		return true;
    	}
        return false;
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
    		return true;
    	}
    	return false;
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
    		events.addAll(events);
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
