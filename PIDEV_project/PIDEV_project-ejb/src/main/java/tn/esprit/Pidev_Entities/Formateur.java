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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@XmlRootElement

public class Formateur implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int id ;
	
	

	

	@Column
	private String nom ;
	
	@Column
	private String prenom ;
	
	 
	@Column
	private String email ;
	
	@Column
	private String numero;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Disponible")
	private Disponible dis;
	
	@OneToMany(mappedBy = "formateur")
	@JsonBackReference

	private List<Formation> formations;
	
	public List<Formation> getFormations() {
		return formations;
	}




	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="Specialite")
	private Specialite specialite ;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	


	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Disponible getDis() {
		return dis;
	}

	public void setDis(Disponible dis) {
		this.dis = dis;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}


	

	public Formateur() {
		
	}

	

	public Formateur(int id, String nom, String prenom, String email, String numero, Disponible dis,
			 Specialite specialite) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numero = numero;
		this.dis = dis;
		this.specialite = specialite;
	}




	public Formateur(String nom, String prenom, String email, String numero, Disponible dis,
			Specialite specialite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numero = numero;
		this.dis = dis;
		this.specialite = specialite;
	}

	@Override
	public String toString() {
		return "Formateur [Id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", numero=" + numero
				+ ", disponible=" + dis + ", formations=" + formations + ", specialite=" + specialite + "]";
	}

	
	
}
