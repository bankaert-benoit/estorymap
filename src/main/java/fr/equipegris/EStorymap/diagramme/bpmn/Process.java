package fr.equipegris.EStorymap.diagramme.bpmn;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Process")
public class Process {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = " Seq_process ")
	@SequenceGenerator(name = " Seq_process ", sequenceName = " Seq_process ", allocationSize = 1)
	private Long id_process;
	public void setId(Long i) {this.id_process = i;}
	public Long getId() {return id_process;}
	
	@Column
	String participant;
	public String getParticipant() {return participant;}
	public void setParticipant(String t) {this.participant=t;}
	
	@OneToMany(mappedBy="Event")
	private Set<Event> list_event = new HashSet<Event>();
	public void addEvent(Event e) { list_event.add(e) ;}
	public Set<Event> getEvent() {return list_event;}
	
	@OneToMany(mappedBy="Activity")
	private Set<Activity> list_activity = new HashSet<Activity>();
	public void addActivity(Activity e) { list_activity.add(e) ;}
	public Set<Activity> getActivity() {return list_activity;}
	
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id_bpmn")
    private Bpmn bpmn;
    public void setBpmn(Bpmn a) {bpmn = a;}
    public Bpmn getRealisateur() {return bpmn;}
	

}
