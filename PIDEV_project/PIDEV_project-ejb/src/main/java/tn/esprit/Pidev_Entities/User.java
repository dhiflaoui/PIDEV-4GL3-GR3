package tn.esprit.Pidev_Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	@Column(name="UT_SALAIRE") 
	Double salaire;
	@Enumerated(EnumType.STRING)
	@Column(name="Role")
	private Role role ;
	// Relation entre employe et congé
	@OneToMany(mappedBy="user")
	private List<Conge>  conge ;
	// Relation entre employe et congé
	@OneToMany(mappedBy="user")
	private List<Absence>  absence ;
	// Relation entre employe et evaluation
	@ManyToMany(mappedBy="Users", cascade = CascadeType.ALL)
	private Set<Evaluation> Evaluations;
	// Relation entre employe et evaluation
	@ManyToOne
	@JoinColumn(name="idMission", referencedColumnName="id", insertable=false , updatable=false)
	private Mission mission;
	// Relation entre manager et equipe
	@OneToMany(mappedBy="managedBy")
	private List<Equipe>  managerOf ;
	// Relation entre employe et equipe
	@OneToMany(mappedBy="membreOf")
	private List<Equipe>  employeOf ;
	// Relation entre manager et project
	@OneToMany(mappedBy="ownedBy")
	private List<Project>  ownerOF ;
	// Relation entre employe et project
	@ManyToOne
	@JoinColumn(name="idProject", referencedColumnName="Project_ID", insertable=false , updatable=false, nullable = true)
	private Project workOn;
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
	public List<Equipe> getEmployeOf() {
		return employeOf;
	}
	public void setEmployeOf(List<Equipe> employeOf) {
		this.employeOf = employeOf;
	}
	public List<Project> getOwnerOF() {
		return ownerOF;
	}
	public void setOwnerOF(List<Project> ownerOF) {
		this.ownerOF = ownerOF;
	}
	public Project getWorkOn() {
		return workOn;
	}
	public void setWorkOn(Project workOn) {
		this.workOn = workOn;
	}
	public User(int id, String cin, String nom, String prenom, String adresseMail, String motdp, String photo,
			String cv, String ville, String tel, int solde_conge, Double salaire, Role role, List<Conge> conge,
			List<Absence> absence, Set<Evaluation> evaluations, Mission mission, List<Equipe> managerOf,
			List<Equipe> employeOf, List<Project> ownerOF, Project workOn) {
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
		this.salaire = salaire;
		this.role = role;
		this.conge = conge;
		this.absence = absence;
		Evaluations = evaluations;
		this.mission = mission;
		this.managerOf = managerOf;
		this.employeOf = employeOf;
		this.ownerOF = ownerOF;
		this.workOn = workOn;
	}
	
	public User( String cin, String nom, String prenom, String adresseMail, String motdp, String photo,
			String cv, String ville, String tel, int solde_conge, Double salaire, Role role) {
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
		this.salaire = salaire;
		this.role = role;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresseMail="
				+ adresseMail + ", motdp=" + motdp + ", photo=" + photo + ", cv=" + cv + ", ville=" + ville + ", tel="
				+ tel + ", solde_conge=" + solde_conge + ", salaire=" + salaire + ", role=" + role + ", conge=" + conge
				+ ", absence=" + absence + ", Evaluations=" + Evaluations + ", mission=" + mission + ", managerOf="
				+ managerOf + ", employeOf=" + employeOf + ", ownerOF=" + ownerOF + ", workOn=" + workOn + "]";
	}

	public User( int userIdToBeUpdated,String cin, String nom, String prenom, String adresseMail, String motdp, String photo,
			String cv, String ville, String tel, int solde_conge, Double salaire, Role role) {
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
		this.salaire = salaire;
		this.role = role;
	}
	

}