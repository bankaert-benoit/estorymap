package fr.equipegris.EStorymap.diagramme.bpmn;

import javax.persistence.*;
import fr.equipegris.EStorymap.diagramme.AppliException;
import fr.equipegris.EStorymap.jpa.EntitySingleton;

public class ManagerBpmn {
	private EntityManager persistance;

	public ManagerBpmn() {
		this.persistance=EntitySingleton.getManager();
	}

	public Bpmn ajouterBpmn(String titre) throws AppliException {
		Bpmn p = new Bpmn();
		p.setTitre(titre);
		try {
			persistance.persist(p);
		} catch (Exception e) {
			throw new AppliException(e);
		}
		return p;
	}

}
