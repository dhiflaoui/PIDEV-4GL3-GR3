package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Entities.Formation;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Entities.User;
import tn.esprit.Pidev_Services.FormateurService;
import tn.esprit.Pidev_Services.FormationService;

@ManagedBean(name = "formationBean")
@SessionScoped
public class FormationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String titre;
	private String objectifs;
	private String date;
	private Integer duree;
	private Integer nbrP;
	private Integer prix;
	private Formateur formateur ;
	private User user ;

	private Specialite specialite;
	private String formateurIdToBeUpdated;
	private int selectFormateurById;
	private int selectUserById;

	

	@EJB
	FormationService formationService;
	@EJB
	FormateurService formateurService;


	public void ajouterFormation() {
		Formateur forSelected = formateurService.getFormateurById(selectFormateurById);

		Formation abs = new Formation(titre, objectifs, date, duree,prix,nbrP,  specialite);
		abs.setFormateur(forSelected);
		formationService.ajouterFormation(abs);
	
	}
	public void mettreAjourEmploye() {
		Formateur forSelected = formateurService.getFormateurById(selectFormateurById);

		Formation f = new Formation(Integer.valueOf(this.formateurIdToBeUpdated),titre, objectifs, date, duree,prix,nbrP, formateur, specialite);
		System.out.println(f.toString());
		f.setFormateur(forSelected);

		formationService.modifierFormation(f);
	}
	

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getSelectFormateurById() {
		return selectFormateurById;
	}

	public void setSelectFormateurById(int selectFormateurById) {
		this.selectFormateurById = selectFormateurById;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	private List<Formation> formations ;
	public List<Formation> getFormations() {
		formations = formationService.getAllFormation();

		return formations;
	}
	


	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	private List<Formateur> formateurs;
	public List<Formateur> getFormateurs(){
		formateurs = formateurService.getAllFormateursDis();
		return formateurs;
	}
	private List<User> users;

	public List<User> getUsers(){
		users = formateurService.getAllUsers();
		return users;
	}
	
	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public Integer getNbrP() {
		return nbrP;
	}
	public void setNbrP(Integer nbrP) {
		this.nbrP = nbrP;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	public String getFormateurIdToBeUpdated() {
		return formateurIdToBeUpdated;
	}
	public void setFormateurIdToBeUpdated(String formateurIdToBeUpdated) {
		this.formateurIdToBeUpdated = formateurIdToBeUpdated;
	}


	public FormateurService getFormateurService() {
		return formateurService;
	}


	public void setFormateurService(FormateurService formateurService) {
		this.formateurService = formateurService;
	}


	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}


	public int getSelectUserById() {
		return selectUserById;
	}

	public void setSelectUserById(int selectUserById) {
		this.selectUserById = selectUserById;
	}

	public void removeFormation(int formationId) {

		formationService.SupprimerFormation(formationId);
	}

	
	public void modifier(Formation formation) {
		this.setTitre(formation.getTitre());
		this.setObjectifs(formation.getObjectifs());
		this.setDate(formation.getDate());
		this.setDuree(formation.getDuree());
		this.setSpecialite(formation.getSpecialtie());
		this.setSelectUserById(formation.getFormateur().getId());
		this.setPrix(formation.getPrix());
		this.setNbrP(formation.getNbrP());


		this.formateurIdToBeUpdated=String.valueOf(formation.getId());
		System.out.println("retrevied id => " + formation.getId());

	}

	
	public String getTitre() {
		return titre;
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

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getObjectifs() {
		return objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}




	
	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public String getFormationIdToBeUpdated() {
		return formateurIdToBeUpdated;
	}

	public void setFormationIdToBeUpdated(String formationIdToBeUpdated) {
		this.formateurIdToBeUpdated = formationIdToBeUpdated;
	}

	public FormationService getFormationService() {
		return formationService;
	}

	public void setFormationService(FormationService formationService) {
		this.formationService = formationService;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
