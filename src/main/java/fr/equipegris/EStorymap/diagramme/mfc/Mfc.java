package fr.equipegris.EStorymap.diagramme.mfc;

import fr.equipegris.EStorymap.diagramme.mfc.composant.Acteur;
import fr.equipegris.EStorymap.diagramme.mfc.composant.Flux;

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
	private String titre;
	public String getTitre() {return titre;}
	public void setTitre(String t) {this.titre=t;}


	private List<Acteur> acteurs;

	private List<Flux> flux;

	public Mfc(String titre, List<Acteur> acteurs, List<Flux> flux) {
		this.titre = titre;
		this.acteurs = acteurs;
		this.flux = flux;
	}

	@Override
	public String toString() {
		return "Mfc{" +
				"id_mfc=" + id_mfc +
				", titre='" + titre + '\'' +
				", acteurs=" + acteurs.toString() +
				", flux=" + flux.toString() +
				'}';
	}
}
