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

@Entity 
@Table(name="T_PROJECT")
public class Project implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="Project_ID") 
	int id;
	
	private String clientName;
	
	private int Budget;
	
	@Enumerated(EnumType.STRING)
	private State state ;
	
	@ManyToOne
	@JoinColumn(name="idManager", referencedColumnName="UT_ID", insertable=false , updatable=false, nullable = true)
	private User ownedBy;
	
	@OneToMany(mappedBy="project" , cascade = CascadeType.ALL)
	private List<Task>  tasks;
	


	public Project() {
		super();
	}

	public Project(String clientName, int budget, State state) {
		super();
		this.clientName = clientName;
		Budget = budget;
		this.state = state;
	}

	public Project(String clientName, int budget, State state, User ownedBy) {
		super();
		this.clientName = clientName;
		Budget = budget;
		this.state = state;
		this.ownedBy = ownedBy;
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

	public int getBudget() {
		return Budget;
	}

	public void setBudget(int budget) {
		Budget = budget;
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
	
	
	
	
}
