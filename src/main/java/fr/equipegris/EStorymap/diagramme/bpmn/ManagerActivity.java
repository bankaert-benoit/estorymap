package fr.equipegris.EStorymap.diagramme.bpmn;

import javax.persistence.*;
import java.util.List;
import fr.equipegris.EStorymap.diagramme.AppliException;
import fr.equipegris.EStorymap.jpa.EntitySingleton;

public class ManagerActivity {
	private EntityManager persistance;
    private Query listActivities;

	public ManagerActivity() {
		this.persistance=EntitySingleton.getManager();
	}

	public Activity ajouterActivity(String name, Process process) throws AppliException {
		Activity p = new Activity();
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
	public List<Activity> listActivities() {
		return (List<Activity>)listActivities.getResultList();
	    }

}
