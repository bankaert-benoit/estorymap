package fr.equipegris.EStorymap.diagramme.bpmn;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BpmnRepository extends CrudRepository<Bpmn,Long> {
}
