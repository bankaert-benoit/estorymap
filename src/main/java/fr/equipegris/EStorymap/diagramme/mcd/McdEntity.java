package fr.equipegris.EStorymap.diagramme.mcd;

import javax.persistence.*;

/**
 * 
 * Represent an entity of MCD 
 *
 */

@Entity(name = "Entity")
public class McdEntity {
	
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
	

}
