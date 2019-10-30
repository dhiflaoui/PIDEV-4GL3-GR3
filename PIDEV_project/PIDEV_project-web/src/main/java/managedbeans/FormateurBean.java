package managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.Pidev_Entities.Disponible;
import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Services.FormateurService;

@ManagedBean(name = "formateurBean")
@SessionScoped
public class FormateurBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private String numero;
	private String email;
	private Disponible disponible;
	private Specialite specialite;
	private String formateurIdToBeUpdated;
	@EJB
	FormateurService formateurService;

	public String ajouterFormateur() throws ParseException {
		formateurService.ajouterFormateur(new Formateur(nom, prenom, email, numero, disponible, specialite) );
		return "successAFormateur?faces-redirect=true";
	}

	private List<Formateur> employes;
	// public List<Formateur> getAllFormateur() { employes =
	// formateurService.getFormateurDispo(); return employes;
//}	

	public List<Formateur> getEmployes() {
		employes = formateurService.getAllFormateurs();
		return employes;
	}
	private List<Formateur> employesDis;
	public List<Formateur> getEmployesDis() {
		employesDis = formateurService.getAllFormateursDis();
		return employesDis;
	}

	public void removeFormateur(int formateurId) {

		formateurService.SupprimerFormateur(formateurId);
	}

	public void modifier(Formateur formateur) {
		this.setEmail(formateur.getEmail());
		this.setDisponible(formateur.getDis());
		this.setNom(formateur.getNom());
		this.setPrenom(formateur.getPrenom());
		this.setNumero(formateur.getNumero());
		this.setSpecialite(formateur.getSpecialite());
		this.formateurIdToBeUpdated=String.valueOf(formateur.getId());
		System.out.println("retrevied id => " + formateur.getId());

	}

	public void mettreAjourEmploye() {
		System.out.println("==> " + this.formateurIdToBeUpdated);

		Formateur f = new Formateur(Integer.valueOf(this.formateurIdToBeUpdated), nom, prenom, email, numero, disponible, specialite);
		System.out.println(f.toString());
		formateurService.modifierFormateur(f);
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Disponible getDisponible() {
		return disponible;
	}

	public void setDisponible(Disponible disponible) {
		this.disponible = disponible;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
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

	public void setEmployes(List<Formateur> employes) {
		this.employes = employes;
	}

	public String getFormateurIdToBeUpdated() {
		return formateurIdToBeUpdated;
	}

	public void setFormateurIdToBeUpdated(String formateurIdToBeUpdated) {
		this.formateurIdToBeUpdated = formateurIdToBeUpdated;
	}



}
