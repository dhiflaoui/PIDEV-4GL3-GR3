package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



public class Formateur implements Serializable {

	
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="Id_Formateur")
	private int Id ;
	
	@Column(name="Nom")
	private String nom ;
	
	@Column(name="Pernom")
	private String prenom ;
	
	 
	@Column(name="Email" , unique=true)
	private String email ;
	
	@Column(name="Numero")
	private String numero;
	
	@Column(name="Disponible")
	private Boolean disponible;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Specialite")
	private Specialite specialite ;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public Formateur(int id, String nom, String prenom, String email, String numero, Boolean disponible,
			Specialite specialite) {
		super();
		Id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.numero = numero;
		this.disponible = disponible;
		this.specialite = specialite;
	}

	public Formateur() {
		
	}

	@Override
	public String toString() {
		return "Formateur [Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", numero=" + numero
				+ ", disponible=" + disponible + ", specialite=" + specialite + "]";
	}
	
	
}
