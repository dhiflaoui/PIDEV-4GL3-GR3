package tn.esprit.Pidev_Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name="T_BUG")
public class Bug {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="BUG_ID") 
	int id;
	
	private String title;
	
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date reportDate ;
	
	@Enumerated(EnumType.STRING)
	private BugState state;
	
	@ManyToOne
	@JoinColumn(name="Project_ID", referencedColumnName="Project_ID", insertable=false , updatable=false, nullable = true)
	private Project project;
	
	public Bug() {
		super();
	}

	public Bug(String title, String description, Date reportDate, BugState state) {
		super();
		this.title = title;
		this.description = description;
		this.reportDate = reportDate;
		this.state = state;
	}

	public Bug(String title, String description, Date reportDate, BugState state, Project project) {
		super();
		this.title = title;
		this.description = description;
		this.reportDate = reportDate;
		this.state = state;
		this.project = project;
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

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public BugState getState() {
		return state;
	}

	public void setState(BugState state) {
		this.state = state;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
}
