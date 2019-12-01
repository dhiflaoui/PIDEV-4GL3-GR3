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
public class Absence implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	@Column
	String file;
	@Column
	String decision; 
	@Enumerated(EnumType.STRING)
	@Column
	private ABS_Etat etat;
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
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public ABS_Etat getEtat() {
		return etat;
	}
	public void setEtat(ABS_Etat etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Absence(int id, Date dateDebut, Date dateFin, String file, String decision, ABS_Etat etat, User user) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.file = file;
		this.decision = decision;
		this.etat = etat;
		this.user = user;
	}
	public Absence( Date dateDebut, Date dateFin, String file, String decision, ABS_Etat etat, User user) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.file = file;
		this.decision = decision;
		this.etat = etat;
		this.user = user;
	}
	
	public Absence( Date dateDebut, Date dateFin, String decision, ABS_Etat etat) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.decision = decision;
		this.etat = etat;
	}
	
	public Absence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Absence [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", file=" + file
				+ ", decision=" + decision + ", etat=" + etat + ", user=" + user + "]";
	}
	

}
