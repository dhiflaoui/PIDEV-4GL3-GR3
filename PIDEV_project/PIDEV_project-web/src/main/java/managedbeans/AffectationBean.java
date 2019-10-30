package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.Pidev_Entities.Affectation;
import tn.esprit.Pidev_Entities.Formation;
import tn.esprit.Pidev_Entities.User;
import tn.esprit.Pidev_Services.AffectationService;
import tn.esprit.Pidev_Services.FormateurService;
import tn.esprit.Pidev_Services.FormationService;

@ManagedBean(name = "affectationBean")
@SessionScoped
public class AffectationBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer score;
	private Formation formations ;
	private User user ;
	private int selectUserById;
	private int selectForamtionrById;
	private String formationIdToBeUpdated;
	@EJB
	FormationService formationService;
	@EJB
	FormateurService formateurService;
	@EJB
	AffectationService affectationService;
	
	public void affectation() {
		
			User userSelected = formateurService.getUserById(selectUserById);
			Formation formationSelected = formationService.getFormationById(selectForamtionrById);
			Affectation aff = new Affectation(score);
			aff.setScore(0);

			aff.setFormations(formationSelected);
			aff.setUsers(userSelected);

			affectationService.ajouterAffectation(aff);
			
		
		
	}
	public void removeAffectation(int formationId) {

		affectationService.SupprimerAffectation(formationId);
	}

	
	public void mettreAjourAffectation() {
		User userSelected = formateurService.getUserById(selectUserById);
		Formation formationSelected = formationService.getFormationById(selectForamtionrById);
		
		Affectation aff = new Affectation(Integer.valueOf(this.formationIdToBeUpdated),score);

		
		aff.setFormations(formationSelected);
		aff.setUsers(userSelected);

		affectationService.modifierAffectation(aff);
	}
	
	public void modifier(Affectation formation) {
		this.setSelectForamtionrById(formation.getFormations().getId());
		this.setSelectUserById(formation.getUsers().getId());
this.setScore(formation.getScore());

		this.formationIdToBeUpdated=String.valueOf(formation.getId());
		System.out.println("retrevied id => " + formation.getId());

	}
	
	
	
	
	private List<Affectation> affectations ;
	public List<Affectation> getAffectations() {
		affectations = affectationService.getAllAffectation();

		return affectations;}

	private List<User> users;

	public List<User> getUsers(){
		users = formateurService.getAllUsers();
		return users;
	}
	private List<Formation> allformation;

	public List<Formation> getAllformation(){
		allformation = formationService.getAllFormation();
		return allformation;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getSelectUserById() {
		return selectUserById;
	}


	public void setSelectUserById(int selectUserById) {
		this.selectUserById = selectUserById;
	}


	public int getSelectForamtionrById() {
		return selectForamtionrById;
	}


	public void setSelectForamtionrById(int selectForamtionrById) {
		this.selectForamtionrById = selectForamtionrById;
	}


	public FormationService getFormationService() {
		return formationService;
	}


	public void setFormationService(FormationService formationService) {
		this.formationService = formationService;
	}


	public FormateurService getFormateurService() {
		return formateurService;
	}


	public void setFormateurService(FormateurService formateurService) {
		this.formateurService = formateurService;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public Integer getScore() {
		return score;
	}


	public void setScore(Integer score) {
		this.score = score;
	}


	public Formation getFormations() {
		return formations;
	}


	public void setFormations (Formation formations) {
		this.formations = formations;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public String getFormationIdToBeUpdated() {
		return formationIdToBeUpdated;
	}

	public void setFormationIdToBeUpdated(String formationIdToBeUpdated) {
		this.formationIdToBeUpdated = formationIdToBeUpdated;
	}

	public void setAllformation(List<Formation> allformation) {
		this.allformation = allformation;
	}

	public AffectationService getAffectationService() {
		return affectationService;
	}
	public void setAffectationService(AffectationService affectationService) {
		this.affectationService = affectationService;
	}
	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}
	
	
	
}
