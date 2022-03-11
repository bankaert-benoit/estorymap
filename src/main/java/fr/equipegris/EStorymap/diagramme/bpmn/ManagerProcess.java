package fr.equipegris.EStorymap.diagramme.bpmn;

import javax.persistence.*;
import java.util.List;
import fr.equipegris.EStorymap.diagramme.AppliException;
import fr.equipegris.EStorymap.jpa.EntitySingleton;

public class ManagerProcess {
	private EntityManager persistance;
    private Query listProcess;

	public ManagerProcess() {
		this.persistance=EntitySingleton.getManager();
	}

	public Process ajouterProcess(String name, Bpmn bpmn) throws AppliException {
		Process p = new Process();
		p.setBpmn(bpmn);
		p.setParticipant(name);
		try {
			persistance.persist(p);
		} catch (Exception e) {
			throw new AppliException(e);
		}
		return p;
	}
	
	@SuppressWarnings("unchecked")
	public List<Process> listProcess() {
		return (List<Process>)listProcess.getResultList();
	    }

}
