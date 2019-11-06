package managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import mailer.SendMail;
import models.Mail;
import tn.esprit.PidevService.Impl.AbsenceService;
import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.Pidev_Entities.ABS_Etat;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.User;

@ManagedBean(name = "teamBean") 
@SessionScoped
public class TeamBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
    private String description;

	private int selectUserById;
	private int selectEquipeById;
	
	
	@EJB EquipeService equipeService;
	
	private List<Equipe> equipes;
	
	
	public List<Equipe> getAllEquipes(){
		equipes = equipeService.getAllEquipes(); 
		return equipes;
	}
	
	public List<Equipe> getMyEquipes(){
		equipes = equipeService.getMyEquipes();  
		return equipes;
	}
	
	@EJB EmployeService employeService;
	
	private List<User> users;
	
	public List<User> getUsers(){
		users = employeService.getAllUser(); 
		return users;
	}
	
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public String AssignToTeam() {
		User userSelected = employeService.getUserById(selectUserById);
		Equipe equipeSelected = equipeService.getEquipeById(selectEquipe);
		equipeService.AssignUserTo(equipeSelected,userSelected);
		System.out.println(userSelected.getNom()+"assigné avec succés à "+equipeSelected.getTitle());
		return "succes-Assignement-Equipe?faces-redirect=true";
	}
	
	public EmployeService getEmployeService() {
		return employeService;
	}
	
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	public EquipeService getEquipeService() {
		return equipeService;
	}
	
	public void setEquipeService(EquipeService equipeService) {
		this.equipeService = equipeService;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public int getSelectUserById() {
		return selectUserById;
	}

	public void setSelectUserById(int selectUserById) {
		this.selectUserById = selectUserById;
	}

	




}
