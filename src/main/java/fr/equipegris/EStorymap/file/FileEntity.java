
package fr.equipegris.EStorymap.file;

import javax.persistence.*;

@Entity
public class FileEntity {
	
	@Id
	@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_file ")
	@SequenceGenerator ( name =" Seq_file ", sequenceName =" Seq_file ", allocationSize =1)
	private Long id_file;
	
	private String filename;
	@Column(length = 32767)
	private byte[] content;
	
	/**
	 * Creation of a FileEntity
	 * @param filename name of file
	 * @param content content of file
	 */
	public FileEntity(String filename, byte[] content) {
		this.filename = filename;
		this.content = content;
	}
	
	/**
	 * 
	 * @return name of this file
	 */
	public String getFilename() {
		return this.filename;
	}
	
	/**
	 * Set a new name for this file
	 * @param name
	 */
	public void setFilename(String name) {
		this.filename = name;
	}
	
	/**
	 * 
	 * @return content of this file
	 */
	public byte[] getContent() {
		return this.content;
	}
	
	/**
	 * Set new content for this file.
	 * Overwrite current content.
	 * @param newContent to overwrite
	 */
	public void setContent(byte[] newContent) {
		this.content = newContent;
	}
}
