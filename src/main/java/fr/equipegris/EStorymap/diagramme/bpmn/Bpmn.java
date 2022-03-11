package fr.equipegris.EStorymap.diagramme.bpmn;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="BPMN")
public class Bpmn {
	
	private ManagerProcess mp;
	private ManagerActivity ma;
	private ManagerEvent me;
	private EntityManager persistance;
	
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
	
	@OneToMany(mappedBy="Process")
	private Set<Process> list_process = new HashSet<Process>();
	public void addProcess(Process e) { list_process.add(e) ;}
	public Set<Process> getProcess() {return list_process;}
	
	public void debuter() {
        this.persistance.getTransaction().begin();
    }

    public ManagerProcess getManagerProcess() {
    	return mp;
    }
    public ManagerActivity getManagerActivity() {
		return ma;
    }
    
    public ManagerEvent getManagerEvent() {
    	return me;
    }

    public void valider() {
        this.persistance.getTransaction().commit();

    }
	
}
