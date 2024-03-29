package tn.esprit.Pidev_Entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

@Entity 
@XmlRootElement

public class Conge implements Serializable{
	
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id; 
	@Temporal(TemporalType.DATE)
	@Column
	private Date dateDebut ;
	@Temporal(TemporalType.DATE)
	@Column
	private Date dateFin ;
	@Column( nullable = true) 
	String file;
	@Enumerated(EnumType.STRING)
	@Column
	private Conge_Type type; 
	@Enumerated(EnumType.STRING)
	@Column
	private Conge_Etat etat; 
	@ManyToOne
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Conge_Type getType() {
		return type;
	}
	public void setType(Conge_Type type) {
		this.type = type;
	}
	public Conge_Etat getEtat() {
		return etat;
	}
	public void setEtat(Conge_Etat etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Conge(int id, Date dateDebut, Date dateFin, String file, Conge_Type type, Conge_Etat etat, User user) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.file = file;
		this.type = type;
		this.etat = etat;
		this.user = user;
	}
	public Conge( Date dateDebut, Date dateFin, Conge_Type type) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.type = type;
	}
	public Conge() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Conge [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", file=" + file + ", type="
				+ type + ", etat=" + etat + ", user=" + user + "]";
	}
	
	
	
	

}
