package fr.equipegris.EStorymap.tips;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TipsEntity {
	@Id
	@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_tips ")
	@SequenceGenerator ( name =" Seq_tips ", sequenceName =" Seq_tips ", allocationSize =1)
	private Long id_tips;
	
	@Column
	private String content;
	public String getContent() {
		return this.content;
	}
	
	public TipsEntity(String text) {
		this.content = text;
	}
	
}
