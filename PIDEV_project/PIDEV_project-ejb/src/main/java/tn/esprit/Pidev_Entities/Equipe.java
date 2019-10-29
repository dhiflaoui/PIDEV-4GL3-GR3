package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="T_EQUIPE") 
public class Equipe implements Serializable {
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="EQ_ID") 
	int id; 
	
	
	@ManyToOne
	@JoinColumn(name="idManager", referencedColumnName="UT_ID", insertable=false , updatable=false, nullable = true)
	private User managedBy;
	
	
	@OneToMany(mappedBy="memberOf")
	private List<User>  members ;
	
	
	private String title ;
	private String description;
	private String score ;
	

}
