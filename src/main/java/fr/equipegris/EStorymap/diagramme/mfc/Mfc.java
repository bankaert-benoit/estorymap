package fr.equipegris.EStorymap.diagramme.mfc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

//@Entity
//@Table(name="MFC")
public class Mfc {
	
	//@Id
	//@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_mfc ")
	//@SequenceGenerator ( name =" Seq_mfc ", sequenceName =" Seq_mfc ", allocationSize =1)
	private Long id_mfc;
	public void setId(Long i) {this.id_mfc=i;}
	public Long getId() {return id_mfc;}
	
	//@Column
	String titre;
	public String getTitre() {return titre;}
	public void setTitre(String t) {this.titre=t;}




	public Mfc(String titre) {
		this.titre = titre;

	}



}
