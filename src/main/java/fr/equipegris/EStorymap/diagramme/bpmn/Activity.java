package fr.equipegris.EStorymap.diagramme.bpmn;

import javax.persistence.*;

@Entity(name="Activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " Seq_activity ")
	@SequenceGenerator(name = " Seq_activity ", sequenceName = " Seq_activity ", allocationSize = 1)
	private Long id_activity;
	public void setId(Long i) {this.id_activity = i;}
	public Long getId() {return id_activity;}
	
	@Column
	String name;
	public String getName() {return name;}
	public void setName(String t) {this.name=t;}
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_process")
    private Process process;
    public void setProcess(Process a) {process = a;}
    public Process getRealisateur() {return process;}
	
}
