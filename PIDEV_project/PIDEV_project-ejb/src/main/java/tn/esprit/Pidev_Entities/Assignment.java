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
@Table(name="T_ASSIGNMENT")
public class Assignment implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="ASSIGNMENT_ID") 
	int id;
	
	private String title;
	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startedAt
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date finishedAt
	
	@ManyToOne
	@JoinColumn(name="idEmployee", referencedColumnName="UT_ID", insertable=false , updatable=false)
	private User  emp;
	
	@OneToOne
	private Task task;
	
	
	
	
}
