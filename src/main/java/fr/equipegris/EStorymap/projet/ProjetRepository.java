package fr.equipegris.EStorymap.projet;

import fr.equipegris.EStorymap.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends CrudRepository<Projet,Long> {

    @Query("SELECT p FROM Projet p WHERE owner = ?1")
    Iterable<Projet> getProjectByOwner(User owner);

}
