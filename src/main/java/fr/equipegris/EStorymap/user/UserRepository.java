package fr.equipegris.EStorymap.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String > {

    @Query(value = "SELECT u FROM Utilisateur u WHERE u.id = ?1")
    User findbyId(String id);

}
