package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity 
@XmlRootElement
public class User implements Serializable{ 
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column
	int id; 
	@Column
	String cin;
	@Column
	String nom; 
	@Column
	String prenom; 
	@Column
	String adresseMail; 
	@Column
	String motdp;
	@Column
	String photo;
	@Column
	String cv;
	@Column
	String ville;
	@Column
	String tel;
	@Column
	int solde_conge;
	@Column( nullable = true)
	int solde_absence;
	@Column
	Double salaire;

	@Enumerated(EnumType.STRING)
	@Column
	private Role role ;
	private Boolean ToBeEval; 

	@OneToMany(mappedBy = "user")	
	@JsonBackReference(value = "test")
	private List<Formation> formation;
	
	@OneToMany(mappedBy = "users")
	@JsonBackReference
	private List<Affectation> affectation;
	
	public List<Formation> getFormation() {
		return formation;
	}
	public void setFormation(List<Formation> formation) {
		this.formation = formation;
	}

	@Enumerated(EnumType.STRING)
	@Column
	private Specialite specialite;


	// Relation entre employe et congé
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Conge>  conge ;
	
	// Relation entre employe et congé
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Absence>  absence ;
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Publication>  publication ;
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Feedback>  feedback ;
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Reactp> reactp ;
	
	// Relation entre employe et evaluation
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	@JsonBackReference
	private List<Evaluation> evaluations;
	// Relation entre employe et evaluation
	@ManyToOne
	@JoinColumn(referencedColumnName="id", insertable=false , updatable=false)
	private Mission mission;
	// Relation entre manager et equipe
	//Yassine ********************************************
	
		// Relation entre manager et equipe
		@OneToMany(mappedBy="managedBy" , cascade = CascadeType.PERSIST)
		@JsonBackReference

		private List<Equipe>  managerOf ;
		
		// Relation entre employe et equipe
		@ManyToOne
		@JoinColumn( referencedColumnName="id", insertable=false , updatable=false)
		private Equipe  memberOf;
		
		// Relation entre manager et project
		@OneToMany(mappedBy="ownedBy")
		@JsonBackReference

		private List<Project>  ownerOF ;
		
		// Relation entre employee et assignements
		@OneToMany(mappedBy="emp", cascade = CascadeType.ALL)
		@JsonBackReference
		private List<Assignment>  assignments ;
		
		
		
		//Yassine **************************************
		
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	
	public void setCin(String cin) {
		this.cin = cin;
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
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getMotdp() {
		return motdp;
	}
	public void setMotdp(String motdp) {
		this.motdp = motdp;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getSolde_conge() {
		return solde_conge;
	}
	public void setSolde_conge(int solde_conge) {
		this.solde_conge = solde_conge;
	}
	public Double getSalaire() {
		return salaire;
	}
	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Conge> getConge() {
		return conge;
	}
	public void setConge(List<Conge> conge) {
		this.conge = conge;
	}
	public List<Absence> getAbsence() {
		return absence;
	}
	public void setAbsence(List<Absence> absence) {
		this.absence = absence;
	}

	public Mission getMission() {
		return mission;
	}
	public void setMission(Mission mission) {
		this.mission = mission;
	}
	public List<Equipe> getManagerOf() {
		return managerOf;
	}
	public Boolean getToBeEval() {
		return ToBeEval;
	}
	public void setToBeEval(Boolean toBeEval) {
		ToBeEval = toBeEval;
	}
	
	
	
	public List<Reactp> getReactp() {
		return reactp;
	}
	public void setReactp(List<Reactp> reactp) {
		this.reactp = reactp;
	}
	public User( String cin, String nom, String prenom, String adresseMail, String motdp, String photo,
			String cv, String ville, String tel, int solde_conge, int solde_absence, Double salaire, Role role,Specialite specialite) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.motdp = motdp;
		this.photo = photo;
		this.cv = cv;
		this.ville = ville;
		this.tel = tel;
		this.solde_conge = solde_conge;
		this.solde_absence = solde_absence;

		this.salaire = salaire;
		this.role = role;
		this.specialite = specialite;

	}
	public User( int userIdToBeUpdated,String cin, String nom, String prenom, String adresseMail, String motdp, String ville, String tel, int solde_conge, int solde_absence, Double salaire, Role role,Specialite specialite) {
		super();
		this.id = userIdToBeUpdated;

		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.motdp = motdp;
		
		this.ville = ville;
		this.tel = tel;
		this.solde_conge = solde_conge;
		this.solde_absence = solde_absence;

		this.salaire = salaire;
		this.role = role;
		this.specialite = specialite;

	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( String cin) {
		super();

		this.cin = cin;


	}

	public User( int userIdToBeUpdated,String cin, String nom, String prenom, String adresseMail, String motdp, String photo,
			String cv, String ville, String tel, int solde_conge,int solde_absence, Double salaire, Role role, Specialite specialite) {
		super();
		this.id = userIdToBeUpdated;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.motdp = motdp;
		this.photo = photo;
		this.cv = cv;
		this.ville = ville;
		this.tel = tel;
		this.solde_conge = solde_conge;
		this.solde_absence = solde_absence;

		this.salaire = salaire;
		this.role = role;
		this.specialite = specialite;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresseMail="
				+ adresseMail + ", motdp=" + motdp + ", photo=" + photo + ", cv=" + cv + ", ville=" + ville + ", tel="
				+ tel + ", solde_conge=" + solde_conge +  ", solde_absence=" + solde_absence +", salaire=" + salaire + "]";
	}
	public int getSolde_absence() {
		return solde_absence;
	}
	public void setSolde_absence(int solde_absence) {
		this.solde_absence = solde_absence;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public List<Affectation> getAffectation() {
		return affectation;
	}
	public void setAffectation(List<Affectation> affectation) {
		this.affectation = affectation;
	}
	public Equipe getMemberOf() {
		return memberOf;
	}
	public void setMemberOf(Equipe memberOf) {
		this.memberOf = memberOf;
	}
	public List<Project> getOwnerOF() {
		return ownerOF;
	}
	public void setOwnerOF(List<Project> ownerOF) {
		this.ownerOF = ownerOF;
	}
	public List<Assignment> getAssignments() {
		return assignments;
	}
	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
	public void setManagerOf(List<Equipe> managerOf) {
		this.managerOf = managerOf;
	}
	
	public List<Evaluation> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public User(int id, String cin, String nom, String prenom, String adresseMail, String motdp, String photo,
			String cv, String ville, String tel, int solde_conge, int solde_absence, Double salaire, Role role,
			List<Formation> formation, List<Affectation> affectation, Specialite specialite, List<Conge> conge,
			List<Absence> absence, List<Evaluation> evaluations, Mission mission, List<Equipe> managerOf,
			Equipe memberOf, List<Project> ownerOF, List<Assignment> assignments) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseMail = adresseMail;
		this.motdp = motdp;
		this.photo = photo;
		this.cv = cv;
		this.ville = ville;
		this.tel = tel;
		this.solde_conge = solde_conge;
		this.solde_absence = solde_absence;
		this.salaire = salaire;
		this.role = role;
		this.formation = formation;
		this.affectation = affectation;
		this.specialite = specialite;
		this.conge = conge;
		this.absence = absence;
		this.evaluations = evaluations;
		this.mission = mission;
		this.managerOf = managerOf;
		this.memberOf = memberOf;
		this.ownerOF = ownerOF;
		this.assignments = assignments;
	}
	public List<Publication> getPublication() {
		return publication;
	}
	public void setPublication(List<Publication> publication) {
		this.publication = publication;
	}
	public List<Feedback> getFeedback() {
		return feedback;
	}
	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}
	
	

}
