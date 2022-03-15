package fr.equipegris.EStorymap.diagramme.mcd;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="MCD")
public class Mcd {
	
	@Id
	@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_mcd ")
	@SequenceGenerator ( name =" Seq_mcd ", sequenceName =" Seq_mcd ", allocationSize =1)
	private Long id_mcd;
	public void setId(Long i) {this.id_mcd=i;}
	public Long getId() {return id_mcd;}
	
	@Column
	String titre;
	public String getTitre() {return titre;}
	public void setTitre(String t) {this.titre=t;}
	
	@OneToMany(mappedBy="id_entity")
	private Set<McdEntity> mcdEntities =  new HashSet<McdEntity>(); 
	public void addEntity(McdEntity e) { mcdEntities.add(e) ;}
	public Set<McdEntity> getProcess() {return mcdEntities;} 
	
	
}
