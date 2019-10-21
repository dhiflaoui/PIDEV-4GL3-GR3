package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Mission   implements Serializable {

	private static final long serialVersionUID = 35501844688441792L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String location;

	@Temporal(TemporalType.DATE)
	private Date dateStart;
	@Temporal(TemporalType.DATE)
	private Date dateEnd;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id") private User user;
	 */
	@OneToMany(mappedBy="mission")
	private List<User>  user ;
	/*
	 * @OneToMany
	 * 
	 * @JoinColumn(name = "id") private Skills id_skill;
	 */
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
	public Date getDateStart() {
		return dateStart;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Mission(Long id, String name, String description, String location, Date dateStart, Date dateEnd,
			List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.user = user;
	}
	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Mission [id=" + id + ", name=" + name + ", description=" + description + ", location=" + location
				+ ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", user=" + user + "]";
	}

	

}
