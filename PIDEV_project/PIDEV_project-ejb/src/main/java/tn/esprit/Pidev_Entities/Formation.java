package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Formation implements Serializable{
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="Id_Formation")
	private int Id ;
	
	@Column(name="Titre")
	private String Titre ;
	
	@Column(name="Objectifs")
	private String objectifs ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private Date date ;
	
	@Temporal(TemporalType.TIME)
	@Column(name="Duree")
	private Date duree ;

	@ManyToMany(mappedBy="formation")
	private List<Formateur> formateur ;
	
	@Enumerated(EnumType.STRING)
	@Column(name=" Specialtie")
	private Specialite   specialtie ;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Formation.serialVersionUID = serialVersionUID;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTitre() {
		return Titre;
	}

	public void setTitre(String titre) {
		Titre = titre;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public List<Formateur> getFormateur() {
		return formateur;
	}

	public void setFormateur(List<Formateur> formateur) {
		this.formateur = formateur;
	}

	public Specialite getSpecialtie() {
		return specialtie;
	}

	public void setSpecialtie(Specialite specialtie) {
		this.specialtie = specialtie;
	}

	public Formation(int id, String titre, String objectifs, Date date, Date duree, List<Formateur> formateur,
			Specialite specialtie) {
		super();
		Id = id;
		Titre = titre;
		this.objectifs = objectifs;
		this.date = date;
		this.duree = duree;
		this.formateur = formateur;
		this.specialtie = specialtie;
	}

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Formation [Id=" + Id + ", Titre=" + Titre + ", objectifs=" + objectifs + ", date=" + date + ", duree="
				+ duree + ", formateur=" + formateur + ", specialtie=" + specialtie + "]";
	}
	
	
	
	
	
}
