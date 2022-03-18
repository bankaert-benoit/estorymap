package fr.equipegris.EStorymap.diagramme.mcd;

import javax.persistence.*;
import java.util.Set;

/**
 * 
 * Represent an entity of MCD 
 *
 */

@javax.persistence.Entity
public class Entity {
	
	@Id
	@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_entity ")
	@SequenceGenerator ( name =" Seq_entity ", sequenceName =" Seq_entity ", allocationSize =1)
	private Long id_entity;
	public void setId(Long i) {this.id_entity = i;}
	public Long getId() {return id_entity;}
	
	@Column
	private String name;
	public String getName() {return this.name;}
	public void setName(String s) {this.name = s;}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_mcd")
	private Mcd mcd;
	public Mcd getMcd() {return this.mcd;}
	public void setMcd(Mcd m) {}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "id")
	private Set<Attribut> attributs;
	public Set<Attribut> getAttributs(){return this.attributs;}
	public void setAttributs(Set<Attribut> attributs){this.attributs = attributs;}


	public Entity(String name, Set<Attribut> attributs) {
		this.name = name;
		this.attributs = attributs;
	}

	@Override
	public String toString() {
		return "Entity{" +
				"id_entity=" + id_entity +
				", name='" + name + '\'' +
				", mcd=" + mcd +
				", attributs=" + attributs.toString() +
				'}';
	}
}
