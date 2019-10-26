package managedbeans;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PidevService.Impl.AbsenceService;
import tn.esprit.Pidev_Entities.ABS_Etat;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.User;

@ManagedBean(name = "absenceBean") 
@SessionScoped
public class AbsenceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dateDebut ;
	private Date dateFin ;
    private String file;
    private String decision; 
	private ABS_Etat etat;
	private User user;

	@EJB AbsenceService absenceService;

	

	public String addAbs() {
		absenceService.addAbsence(new Absence(dateDebut, dateFin, file, decision, etat, user));
		return "succes-ajout-abs?faces-redirect=true";
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public ABS_Etat getEtat() {
		return etat;
	}
	public void setEtat(ABS_Etat etat) {
		this.etat = etat;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public AbsenceService getAbsenceService() {
		return absenceService;
	}
	public void setAbsenceService(AbsenceService absenceService) {
		this.absenceService = absenceService;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	




}
