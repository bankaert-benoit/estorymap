package fr.equipegris.EStorymap.diagramme.bpmn;

import javax.persistence.*;

@Entity(name="Event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " Seq_event ")
	@SequenceGenerator(name = " Seq_event ", sequenceName = " Seq_event ", allocationSize = 1)
	private Long id_event;
	public void setId(Long i) {this.id_event = i;}
	public Long getId() {return id_event;}
	
	@Column
	String name;
	public String getName() {return name;}
	public void setName(String t) {this.name=t;}
	
	@Column
	Boolean isEnd;
	public Boolean getisEnd() {return isEnd;}
	public void setisEnd(Boolean t) {this.isEnd=t;}
	
	@Column
	Boolean isStart;
	public Boolean getisStart() {return isStart;}
	public void setisStart(Boolean t) {this.isStart=t;}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_process")
    private Process process;
    public void setProcess(Process a) {process = a;}
    public Process getRealisateur() {return process;}
	
}
