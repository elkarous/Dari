package tn.esprit.spring.entities;


	import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.Lob;
	import javax.persistence.Table;


	@Entity
	@Table(name = "files")
	public class FileDB implements Serializable {
	  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
		

	  private String name;

	  private String type;

	  @Lob
	  private byte[] data;

	  public FileDB(Long id, String name, String type, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public String getId() {
		return ""+id ;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FileDB() {
	  }

	  public FileDB(String name, String type, byte[] data) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	  }

	 

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public byte[] getData() {
	    return data;
	  }

	  public void setData(byte[] data) {
	    this.data = data;
	  }

}
