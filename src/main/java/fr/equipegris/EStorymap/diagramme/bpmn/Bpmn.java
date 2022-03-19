package fr.equipegris.EStorymap.diagramme.bpmn;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity(name="BPMN")
public class Bpmn {
	

	
	@Id
	@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_bpmn ")
	@SequenceGenerator ( name =" Seq_bpmn ", sequenceName =" Seq_bpmn ", allocationSize =1)
	private Long id_bpmn;
	public void setId(Long i) {this.id_bpmn=i;}
	public Long getId() {return id_bpmn;}
	
	@Column
	String titre;
	public String getTitre() {return titre;}
	public void setTitre(String t) {this.titre=t;}
	
	@OneToMany(mappedBy="id_process")
	private Set<Process> list_process = new HashSet<Process>();
	public void addProcess(Process e) { list_process.add(e) ;}
	public Set<Process> getProcess() {return list_process;}

	public Bpmn(String titre, Set<Process> processes){
		this.titre = titre;
		this.list_process = processes;
	}

	public Bpmn() {}

	@Override
	public String toString() {
		return "Bpmn{" +
				"id_bpmn=" + id_bpmn +
				", titre='" + titre + '\'' +
				", process='" + list_process.toString() + '\'' +
				'}';
	}
}
