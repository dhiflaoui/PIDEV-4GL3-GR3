package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.Pidev_Entities.Role;
import tn.esprit.Pidev_Entities.User;


@ManagedBean(name = "userBean") 
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nom;
	private String cin;

	private String prenom;
	private String motdp;  
	private String adresseMail; 
	private String photo;
	private String cv;
	private String ville;
	private String tel;
	private int solde_conge;
	private Double salaire;
	private Role role; 
	private Integer userIdToBeUpdated;

	@EJB EmployeService employeService; 
	public void addEmploye() {
		employeService.ajouterUser(new User( cin,  nom,  prenom,  adresseMail,  motdp,  photo,
				 cv,  ville,  tel,  solde_conge,  salaire,  role)); 
		}
	private List<User> users;
	public List<User> getUsers(){
		users = employeService.getAllUser(); 
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void modifier(User user) {
		this.setCin(user.getCin()); 
		this.setNom(user.getNom()); 
		this.setPrenom(user.getPrenom()); 
		this.setMotdp(user.getMotdp()); 
		this.setAdresseMail(user.getAdresseMail()); 
		this.setVille(user.getVille()); 
		this.setRole(user.getRole()); 
		this.setCv(user.getCv()); 
		this.setPhoto(user.getPhoto()); 
		this.setTel(user.getTel()); 
		this.setSolde_conge(user.getSolde_conge()); 
		this.setSalaire(user.getSalaire()); 

		this.setUserIdToBeUpdated(user.getId()); }
	public void mettreAjourUser(){ 
		employeService.updateUser(new User(userIdToBeUpdated, cin,  nom,  prenom,  adresseMail,  motdp,  photo,
				 cv,  ville,  tel,  solde_conge,  salaire,  role)); }
public void removeEmploye(int employeId) {
		
		employeService.deleteUserById(employeId); }

	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMotdp() {
		return motdp;
	}
	public void setMotdp(String motdp) {
		this.motdp = motdp;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
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
	public EmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getUserIdToBeUpdated() {
		return userIdToBeUpdated;
	}

	public void setUserIdToBeUpdated(Integer userIdToBeUpdated) {
		this.userIdToBeUpdated = userIdToBeUpdated;
	} 
	
	
}