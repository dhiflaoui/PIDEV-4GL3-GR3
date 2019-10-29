package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity 
@Table(name="T_UTILISATEUR") 
public class User implements Serializable{ 
	@Id 
	@GeneratedValue( strategy= GenerationType.IDENTITY) 
	@Column(name="UT_ID") 
	int id; 
	@Column(name="UT_CIN") 
	String cin;
	@Column(name="UT_NOM") 
	String nom; 
	@Column(name="UT_PRENOM") 
	String prenom; 
	@Column(name="UT_ADRESS_MAIL") 
	String adresseMail; 
	@Column(name="UT_MOTDP") 
	String motdp;
	@Column(name="UT_PHOTO") 
	String photo;
	@Column(name="UT_CV") 
	String cv;
	@Column(name="UT_VILLE") 
	String ville;
	@Column(name="UT_TEL") 
	String tel;
	@Column(name="UT_SOLDE_CONGE") 
	int solde_conge;
	@Column(name="UT_SOLDE_ABSENCE", nullable = true)
	int solde_absence;
	@Column(name="UT_SALAIRE") 
	Double salaire;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Role")
	private Role role ;
	@Enumerated(EnumType.STRING)
	@Column(name="Specialite")
	private Specialite specialite;

	// Relation entre employe et congé
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Conge>  conge ;
	// Relation entre employe et congé
	@OneToMany(mappedBy="user", cascade = CascadeType.PERSIST)
	private List<Absence>  absence ;
	// Relation entre employe et evaluation
	@ManyToMany(mappedBy="Users", cascade = CascadeType.ALL)
	private Set<Evaluation> Evaluations;
	// Relation entre employe et evaluation
	@ManyToOne
	@JoinColumn(name="idMission", referencedColumnName="id", insertable=false , updatable=false)
	private Mission mission;
	
	
	//Yassine ********************************************
	
	// Relation entre manager et equipe
	@OneToMany(mappedBy="managedBy")
	private List<Equipe>  managerOf ;
	
	// Relation entre employe et equipe
	@ManyToOne
	@JoinColumn(name="idEquipe", referencedColumnName="EQ_ID", insertable=false , updatable=false)
	private Equipe  memberOf;
	
	// Relation entre manager et project
	@OneToMany(mappedBy="ownedBy")
	private List<Project>  ownerOF ;
	
	// Relation entre employee et assignements
	@OneToMany(mappedBy="emp")
	private List<Assignment>  assignments ;
	
	
	//Yassine **************************************
	public int getId() {
		return id;
	}
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
	public Set<Evaluation> getEvaluations() {
		return Evaluations;
	}
	public void setEvaluations(Set<Evaluation> evaluations) {
		Evaluations = evaluations;
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
	public void setManagerOf(List<Equipe> managerOf) {
		this.managerOf = managerOf;
	}
	public List<Project> getOwnerOF() {
		return ownerOF;
	}
	public void setOwnerOF(List<Project> ownerOF) {
		this.ownerOF = ownerOF;
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
	
	
	

}
