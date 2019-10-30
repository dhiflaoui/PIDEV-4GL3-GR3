package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;




@Entity
public class Formation implements Serializable{
	
	

	public Formation() {
		
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="Id_Formation")
	private int Id ;
	
	@Column(name="Titre")
	private String Titre ;
	
	@Column(name="Objectifs")
	private String objectifs ;
	

	@Column(name="Date")
	private String date ;
	
	@Column(name="Duree")
	private Integer duree ;

	@Column(name="Prix")
	private Integer prix ;
	
	@Column(name="NbrP")
	private Integer nbrP ;
	
	

	@ManyToOne
	private Formateur formateur;
	
	@ManyToOne
	private User user ;
	
	@OneToMany(mappedBy = "formations")
	private List<Affectation> affectation;
	


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
	@Column(name=" Specialtie")
	private Specialite   specialtie ;

	public static long getSerialVersionUID() {
		return serialVersionUID;
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

	public Formateur getFormateur() {
		return formateur;
	}

	public Integer getPrix() {
		return prix;
	}



	public void setPrix(Integer prix) {
		this.prix = prix;
	}



	public Integer getNbrP() {
		return nbrP;
	}



	public void setNbrP(Integer nbrP) {
		this.nbrP = nbrP;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}



	public Specialite getSpecialtie() {
		return specialtie;
	}

	public void setSpecialtie(Specialite specialtie) {
		this.specialtie = specialtie;
	}




	

	





	


	public Formation( String titre, String objectifs, String date, Integer duree, Integer prix, Integer nbrP,  Specialite specialtie) {
		super();
		Titre = titre;
		this.objectifs = objectifs;
		this.date = date;
		this.duree = duree;
		this.prix = prix;
		this.nbrP = nbrP;
		this.specialtie = specialtie;
	}



	








	public Formation(int id, String titre, String objectifs, String date, Integer duree, Integer prix, Integer nbrP,
			Formateur formateur, Specialite specialtie) {
		super();
		Id = id;
		Titre = titre;
		this.objectifs = objectifs;
		this.date = date;
		this.duree = duree;
		this.prix = prix;
		this.nbrP = nbrP;
		this.formateur = formateur;
		this.specialtie = specialtie;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Integer getDuree() {
		return duree;
	}



	public void setDuree(Integer duree) {
		this.duree = duree;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	

	@Override
	public String toString() {
		return "Formation [Id=" + Id + ", Titre=" + Titre + ", objectifs=" + objectifs + ", date=" + date + ", duree="
				+ duree + ", formateur=" + formateur + ", specialtie=" + specialtie + "]";
	}
	
	
	
	
	
}
