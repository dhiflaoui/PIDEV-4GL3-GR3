	package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity 
@XmlRootElement

public class Equipe implements Serializable {
	
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id; 
	
	
	@ManyToOne
	@JoinColumn( referencedColumnName="id", insertable=false , updatable=false, nullable = true)
	private User managedBy;
	
	
	@OneToMany(mappedBy="memberOf", cascade = CascadeType.PERSIST)
	private List<User>  members ;
	
	
	private String title ;
	private String description;
	private int score ;
	
	
	
	public Equipe() {
		super();
		this.score=0;
	}

	public Equipe(String title, String description, int score) {
		super();
		this.title = title;
		this.description = description;
	}
	
	public Equipe(User managedBy, String title, String description, int score) {
		super();
		this.managedBy = managedBy;
		this.title = title;
		this.description = description;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getManagedBy() {
		return managedBy;
	}
	public void setManagedBy(User managedBy) {
		this.managedBy = managedBy;
	}
	public List<User> getMembers() {
		return members;
	}
	public void setMembers(List<User> members) {
		this.members = members;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
