/**
 * Une interface qui va servir à sauvegarder une astuce en base
 * avec la méthode save() de CrudRepository
 */

package fr.equipegris.EStorymap.tips;

import javax.persistence.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipsEntityRepository extends CrudRepository<TipsEntity, Long> {
}
