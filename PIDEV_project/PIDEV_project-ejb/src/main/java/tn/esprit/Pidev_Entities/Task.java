package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="T_TASK")
public class Task implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="TASK_ID") 
	int id;
	
	private String Title;
	
	private String Description;
	
	@Enumerated(EnumType.STRING)
	private Specialite spec;
	
	@Enumerated(EnumType.STRING)
	private State state;
	
	@Temporal(TemporalType.TIME)
	private Date duration ;
	
	
	@ManyToOne
	@JoinColumn(name="idProject", referencedColumnName="Project_ID", insertable=false , updatable=false, nullable = true)
	private Project project;
	
	@OneToOne(mappedBy="task", cascade = CascadeType.ALL)
	private Assignment assignment;
	
	
	
	public Task() {
		super();
	}

	public Task(String title, String description, Specialite spec, State state, Date duration) {
		super();
		Title = title;
		Description = description;
		this.spec = spec;
		this.state = state;
		this.duration = duration;
	}
	
	
	

	public Task(String title, String description, Specialite spec, State state, Date duration, Project project,
			Assignment assignment) {
		super();
		Title = title;
		Description = description;
		this.spec = spec;
		this.state = state;
		this.duration = duration;
		this.project = project;
		this.assignment = assignment;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Specialite getSpec() {
		return spec;
	}

	public void setSpec(Specialite spec) {
		this.spec = spec;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getDuration() {
		return duration;
	}

	public void setDuration(Date duration) {
		this.duration = duration;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}
	
	

}