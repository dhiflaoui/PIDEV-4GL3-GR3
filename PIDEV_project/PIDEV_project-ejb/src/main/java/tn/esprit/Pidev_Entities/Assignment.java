package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="T_ASSIGNMENT")
public class Assignment implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="ASSIGNMENT_ID") 
	int id;
	
	private String title;
	private String description;
	
	private int finishedIn;
	
	@ManyToOne
	@JoinColumn(name="idEmployee", referencedColumnName="UT_ID", insertable=false , updatable=false)
	private User  emp;
	
	@OneToOne
	private Task task;
	
	
	
	

	public Assignment(String title, String description, int finishedIn, User emp, Task task) {
		super();
		this.title = title;
		this.description = description;
		this.finishedIn = finishedIn;
		this.emp = emp;
		this.task = task;
	}



	public Assignment(String title, String description, int finishedIn) {
		super();
		this.title = title;
		this.description = description;
		this.finishedIn = finishedIn;
	}



	public int getFinishedIn() {
		return finishedIn;
	}



	public void setFinishedIn(int finishedIn) {
		this.finishedIn = finishedIn;
	}



	public Assignment() {
		super();
	}
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	
	public User getEmp() {
		return emp;
	}

	public void setEmp(User emp) {
		this.emp = emp;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	

}
