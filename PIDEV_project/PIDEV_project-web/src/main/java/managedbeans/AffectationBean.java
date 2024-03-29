package managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.mail.search.AndTerm;

import tn.esprit.Pidev_Entities.Affectation;
import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Entities.Formation;
import tn.esprit.Pidev_Entities.User;
import tn.esprit.Pidev_Services.AffectationService;
import tn.esprit.Pidev_Services.FormateurService;
import tn.esprit.Pidev_Services.FormationService;

@ManagedBean(name = "affectationBean")
@SessionScoped
public class AffectationBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer score;
	private String montion;

	public String getMontion() {
		return montion;
	}

	public void setMontion(String montion) {
		this.montion = montion;
	}

	private Formation formations;
	private User  user;
	private int selectUserById;
	private int selectForamtionrById;
	private int selectAffectationById;

	private String formationIdToBeUpdated;
	@EJB
	FormationService formationService;
	@EJB
	FormateurService formateurService;
	@EJB
	AffectationService affectationService;

	public String affectation() throws ParseException {

		User userSelected = formateurService.getUserById(selectUserById);
		Formation formationSelected = formationService.getFormationById(selectForamtionrById);
		Affectation aff = new Affectation(score);
		aff.setScore(0);

		aff.setFormations(formationSelected);
		aff.setUsers(userSelected);
		int nbrPlace = formationSelected.getNbrP();
		double salaire = userSelected.getSalaire();
		int prix = formationSelected.getPrix();
		
		if (nbrPlace == 0) {
			return "echecAAffectationP?faces-redirect=true";

		} else if (prix > salaire) {
			return "echecAAffectationS?faces-redirect=true";

		} else {

			userSelected.setSalaire(salaire - prix);
			formationSelected.setNbrP(nbrPlace - 1);
			formationService.modifierUser(userSelected);
			formationService.modifierFormation(formationSelected);
			affectationService.ajouterAffectation(aff);

			return "successAAffectation?faces-redirect=true";
		}

	}

	public int getSelectAffectationById() {
		return selectAffectationById;
	}

	public void setSelectAffectationById(int selectAffectationById) {
		this.selectAffectationById = selectAffectationById;
	}

	public void removeAffectation(int formationId) {

		affectationService.SupprimerAffectation(formationId);
	}

	public void mettreAjourAffectation() {
	
		User userSelected = formateurService.getUserById(selectUserById);
		Formation formationSelected = formationService.getFormationById(selectForamtionrById);
		Affectation affSelected = affectationService.getAffectationById(selectAffectationById);

		
		
		Affectation f = new Affectation(Integer.valueOf(this.formationIdToBeUpdated),formations,user,score,montion);
		System.out.println(f.toString());
		f.setUsers(userSelected);
		f.setFormations(formationSelected);
		
		
		double salaire = userSelected.getSalaire();
		int prix = formationSelected.getPrix();

		if(score >=10  && score < 15) {

		f.setMontion("bien");
		affectationService.modifierAffectation(f);

		}
		else if (score >= 15 && score < 20 ) {
			double cal = (prix/2);
			
			userSelected.setSalaire( salaire + (prix/2));

			f.setMontion("tres bien , reduction: " +cal+"D");
			affectationService.modifierAffectation(f);
			formationService.modifierUser(userSelected);

		}
		else if (score == 20) {
			userSelected.setSalaire(salaire + prix);

			f.setMontion("Excellent , Formation gratuite");
			affectationService.modifierAffectation(f);
			formationService.modifierUser(userSelected);

		}
		else if(score>=0 && score<10) {
			f.setMontion("Faible il faut rattraper");
			affectationService.modifierAffectation(f);

			
		}
		f.setScore(score);

		affectationService.modifierAffectation(f);
	}
	


	public void modifier(Affectation item) {
		
		this.setScore(item.getScore());
this.setMontion(item.getMontion());
this.setSelectUserById(item.getUsers().getId());
this.setSelectForamtionrById(item.getFormations().getId());

		this.formationIdToBeUpdated = String.valueOf(item.getId());
		System.out.println("retrevied id => " + item.getId());

	}

	private List<Affectation> affectations;

	public List<Affectation> getAffectations() {
		affectations = affectationService.getAllAffectation();

		return affectations;
	}

	private List<User> users;

	public List<User> getUsers() {
		users = formateurService.getAllUsers();
		return users;
	}

	private List<Formation> allformation;

	public List<Formation> getAllformation() {
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

	public void setFormations(Formation formations) {
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
