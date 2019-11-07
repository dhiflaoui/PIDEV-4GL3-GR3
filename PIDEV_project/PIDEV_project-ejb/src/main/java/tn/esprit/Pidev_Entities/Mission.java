package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import EntityBase.AbstractTimestampEntity;
import EntityBase.IBaseEntity;

@Entity
public class Mission extends AbstractTimestampEntity implements Serializable, IBaseEntity {

	private static final long serialVersionUID = 35501844688441792L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String location;
	private String dateStart;
	private String dateEnd;
	@ManyToOne(fetch = FetchType.EAGER)
	private User assignee;
	@Enumerated(EnumType.STRING)
	@Column(name="Specialite")
	private Specialite specialite ;

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id") private User user;
	 */

	public Mission() {
		super();
	}

	public Mission( String name, String description, Specialite specialite,String location, String dateStart, String dateEnd) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.specialite= specialite;
	}
	
	public Mission(Long id, String name, String description) {
		
		this.id = id;
		this.name = name;
		this.description = description;
	
	}
	
	
	

	
	
	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Mission(Long id, String name, String description, String location, String dateStart, String dateEnd,
			User assignee, Specialite specialite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.assignee = assignee;
		this.specialite = specialite;
	}


	public Mission(Long id, String name, String description, String location, String dateStart, String dateEnd,
		Specialite specialite) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.assignee = assignee;
		this.specialite = specialite;
	}

	

	public Mission(String name, String description, Specialite specialite) {
		this.name = name;
		this.description = description;
		this.specialite = specialite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	

}
