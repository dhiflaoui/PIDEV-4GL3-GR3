package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name="T_TASK")
public class Task implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="TASK_ID") 
	int id;
	
	private String Title;
	
	private String Description;
	
	@Enumerated(EnumType.String)
	private Specialite spec;
	
	@Enumerated(EnumType.String)
	private State state;
	
	@Temporal(TemporalType.TIME)
	private Date duration
	
	
	@ManyToOne
	@JoinColumn(name="idProject", referencedColumnName="Project_ID", insertable=false , updatable=false, nullable = true)
	private Project project;
	
	@OneToOne(mappedBy="task", cascade = CascadeType.ALL)
	private Assignment assignment;
	
	

}