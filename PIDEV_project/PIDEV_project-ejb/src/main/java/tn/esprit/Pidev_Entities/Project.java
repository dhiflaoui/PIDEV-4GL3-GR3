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
@Table(name="T_PROJECT")
public class Project implements Serializable {
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="Project_ID") 
	int id;
	
	private String clientName;
	
	private int Budget;
	
	@Enumerated(EnumType.String)
	private State state ;
	
	@ManyToOne
	@JoinColumn(name="idManager", referencedColumnName="UT_ID", insertable=false , updatable=false, nullable = true)
	private User ownedBy;
	
	@OneToMany(mappedBy="project" , cascade = CascadeType.ALL)
	private List<Tasks>  tasks;
	
}
