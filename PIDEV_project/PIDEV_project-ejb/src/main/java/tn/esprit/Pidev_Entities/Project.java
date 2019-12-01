package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

public class Project implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id;
	
	private String clientName;
	
	private String title;
	
	private String description;
	
	
	private int budget;
	
	@Enumerated(EnumType.STRING)
	private State state ;
	
	@ManyToOne
	@JoinColumn( referencedColumnName="id", insertable=false , updatable=false, nullable = true)
	private User ownedBy;
	
	@OneToMany(mappedBy="project" , cascade = CascadeType.ALL)
	private List<Task>  tasks;
	
	@OneToMany(mappedBy="project" , cascade = CascadeType.ALL)
	private List<Bug>  bugs;

	public Project() {
		super();
	}
	
	
	
	
	
	
	public Project(int id, String clientName, String title, String description, int budget) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
	}






	public Project(String clientName, String title, int budget) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.budget = budget;
	}




	public Project(String clientName, String title, String description, int budget) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
	}




	public Project(String clientName, String title, String description, int budget, State state) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
		this.state = state;
	}

	

	public Project(String clientName, String title, String description, int budget, State state, User ownedBy,
			List<Task> tasks, List<Bug> bugs) {
		super();
		this.clientName = clientName;
		this.title = title;
		this.description = description;
		this.budget = budget;
		this.state = state;
		this.ownedBy = ownedBy;
		this.tasks = tasks;
		this.bugs = bugs;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getClientName() {
		return clientName;
	}




	public void setClientName(String clientName) {
		this.clientName = clientName;
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




	public int getBudget() {
		return budget;
	}




	public void setBudget(int budget) {
		this.budget = budget;
	}




	public State getState() {
		return state;
	}




	public void setState(State state) {
		this.state = state;
	}




	public User getOwnedBy() {
		return ownedBy;
	}




	public void setOwnedBy(User ownedBy) {
		this.ownedBy = ownedBy;
	}

	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Bug> getBugs() {
		return bugs;
	}


	public void setBugs(List<Bug> bugs) {
		this.bugs = bugs;
	}

}
