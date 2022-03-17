package fr.equipegris.EStorymap.user;

import fr.equipegris.EStorymap.projet.Projet;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Utilisateur")
public class User {

    @Id
    @Column(name="idu")
    private String id;
    @Column(name="nom",nullable = false)
    private String name;
    @Column(name="photo",nullable = false)
    private String pictureUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Projet> projetSet;

    public User(){}

    public User(String id,String name, String pictureUrl){
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
