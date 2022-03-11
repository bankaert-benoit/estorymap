package fr.equipegris.EStorymap.user;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 * Spring va generer tous seul les requetes de cette interface
 * De plus, CrudRepository nous fournit deja des methodes de base comme
 * le findAll, le save pour ajouter, l'update et le delete
 * Si il faut une requete plus pousser on peut la créer ici
 */
public interface UserRepository extends CrudRepository<User,String > {

    /**
     * Requete qui cherche un Utilisateur en fonction de son ID
     * @param id est l'id de l'utilisateur souhaite
     * @return l'utilisateur
     */
    @Query(value = "SELECT u FROM Utilisateur u WHERE u.id = ?1")
    User findbyId(String id);

}
