package fr.equipegris.EStorymap.diagramme.bpmn;

import javax.persistence.*;
import java.util.List;
import fr.equipegris.EStorymap.diagramme.AppliException;
import fr.equipegris.EStorymap.jpa.EntitySingleton;

public class ManagerEvent {
	private EntityManager persistance;
    private Query listEvents;

	public ManagerEvent() {
		this.persistance=EntitySingleton.getManager();
	}

	public Event ajouterEvent(String name, Process process, Boolean isEnd, Boolean isStart) throws AppliException {
		Event p = new Event();
		p.setisEnd(isEnd);
		p.setisStart(isStart);
		if (p.isEnd == p.isStart) {throw new AppliException("An event can't be a StartEvent and a EndEvent at the same time");};
		p.setName(name);
		p.setProcess(process);
		try {
			persistance.persist(p);
		} catch (Exception e) {
			throw new AppliException(e);
		}
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public List<Event> listEvents() {
		return (List<Event>)listEvents.getResultList();
	    }

}
