/**
 * Une interface qui va servir à sauvegarder un fichier en base
 * avec la méthode save() de CrudRepository
 */

package fr.equipegris.EStorymap.file;

import javax.persistence.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileEntityRepository extends CrudRepository<FileEntity, Long> {
}
