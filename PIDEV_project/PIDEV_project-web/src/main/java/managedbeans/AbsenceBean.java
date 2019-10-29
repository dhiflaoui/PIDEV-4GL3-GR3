package managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import mailer.SendMail;
import models.Mail;
import tn.esprit.PidevService.Impl.AbsenceService;
import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.Pidev_Entities.ABS_Etat;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.User;
import utils.Util;

@ManagedBean(name = "absenceBean") 
@SessionScoped
public class AbsenceBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dateDebut ;
	private Date dateFin ;
    private Part file;
    private String decision; 
	private ABS_Etat etat;
	private int selectUserById;
	@EJB
	AbsenceService absenceService;
	@EJB
	EmployeService employeService;

	private List<Absence> absences;
	public List<Absence> getAbsences(){
		absences = absenceService.getAllAbs(); 
		return absences;
	}
	public void justifiéClient(Absence item) throws IOException {
		System.out.println("nn354546546546454654654654nnnnnnnnnnnnnoooooooooooooooooooooooo");
		item.setEtat(ABS_Etat.en_cour_de_traitement);
		item.setFile(file.getSubmittedFileName());
		absenceService.updateAbs(item);
		String folderName1 = Util.serverF;
		upload2(folderName1);
		
	}
	public void setMesabsences(List<Absence> mesabsences) {
		this.mesabsences = mesabsences;
	}
	private List<Absence> mesabsences;
	public List<Absence> getMesabsences(){
		int a = LoginBean.getUser().getId();
		System.out.println("leeeeeeeeeeeeeeeeeeeeeeee"+a);
		mesabsences = absenceService.mesAbsence(a); 
		return mesabsences;
	}
	


	
	private List<User> users;
	public List<User> getUsers(){
		users = employeService.getAllUser(); 
		return users;
	}
	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public String addAbs() {
		User userSelected = employeService.getUserById(selectUserById);
		Absence abs = new Absence(dateDebut, dateFin, decision, etat);
		abs.setUser(userSelected);
		absenceService.addAbsence(abs);
		System.out.println("leeeeeeeeeeeeeeeee"+selectUserById+"leeeeeeeeeeeeeeeee"+userSelected.getNom());
		SendMail.send(new Mail("Absence", "Cher(e) " + userSelected.getNom() + "\r\n" + "\r\n"
				+ "Suite à votre absence le: " + abs.getDateDebut() +" à "+abs.getDateFin()
				+ ", je vous adresse ce courrier pour vous informer que vous marquer absent et si votre absence ne seras pas justifié votre salaire seras deminuer par 3% pou chaque jour et si vous etes en mission sa seras 5%.\r\n"
				+"pour justfié votre absence accéder a notre application et envoyer notre un rapport ou une certife qui explique votre absence\r\\n"
				+ "Pour plus de détails, veuillez contacter votre Manager.\r\n" + "\r\n" + "Bien cordialement\r\n"
				+ "\r\n" + " \r\n" + "\r\n" + "L'équipe AdvyTeam", "yousfi.iheb@esprit.tn", "AdvyTeam",
				userSelected.getAdresseMail()));
		return "succes-ajout-abs?faces-redirect=true";
	}
public void justifieAbs(Absence item) {
	Date dateD = item.getDateDebut();
	Date dateF = item.getDateFin();
    long diff = dateF.getTime() - dateD.getTime();

    float res = (diff / (1000*60*60*24));
    System.out.println("Nombre de jours entre les deux dates est: "+res);

    int value = (int) res;
    User user = item.getUser();
	int soldeConge =user.getSolde_conge();
	int soldeAbsence = user.getSolde_absence();
    if (value ==1 && ( soldeConge - value) >=0) {
		user.setSolde_conge(soldeConge -value);	
		employeService.updateUser(user);
		item.setDecision("Votre Solde Congé est diminué par "+value+"jour(s)");
		absenceService.updateAbs(item);

		
    }
    else if (value ==1 && ( soldeConge - value) <=0) {
    	Double salaire = user.getSalaire();
    	user.setSalaire(salaire - ((salaire * 0.3*value)/100));
    	employeService.updateUser(user);
    	item.setDecision("Votre Salaire est diminué par "+((salaire * 0.3*value)/100)+"jour(s)");
		absenceService.updateAbs(item);
    }
    else if (value >1 && ( soldeAbsence - value) >=0) {
    	user.setSolde_absence(soldeAbsence-value);
		employeService.updateUser(user);
		item.setDecision("Votre Solde Absence est diminué par "+value+"jour(s)");
		absenceService.updateAbs(item);
    	
    }
    else if (value >1 && ( soldeAbsence - value) <=0) {
    	Double salaire = user.getSalaire();
    	user.setSalaire(salaire - ((salaire * 0.3*value)/100));
    	employeService.updateUser(user);		
    	item.setDecision("Votre Salaire est diminué par "+((salaire * 0.3*value)/100)+"jour(s)");
		absenceService.updateAbs(item);
    	
    }
    

	item.setEtat(etat.justifié);
		
		absenceService.updateAbs(item);
		}

public void nonJustifieAbs(Absence item) {
	Date dateD = item.getDateDebut();
	Date dateF = item.getDateFin();
    long diff = dateF.getTime() - dateD.getTime();

    float res = (diff / (1000*60*60*24));
    System.out.println("Nombre de jours entre les deux dates est: "+res);

    int value = (int) res;
	item.setEtat(etat.non_justifié);
	User user = item.getUser();
	Double salaire = user.getSalaire();
	user.setSalaire(salaire - ((salaire * 0.3*value)/100));
	employeService.updateUser(user);
	item.setDecision("Votre Salaire est diminué par "+((salaire * 0.3*value)/100)+"jour(s)");
		absenceService.updateAbs(item);}
public void upload2(String folderName1) throws IOException {
	InputStream in = file.getInputStream();
	File f = new File(folderName1 + "\\" + file.getSubmittedFileName());
	f.createNewFile();
	FileOutputStream out = new FileOutputStream(f);
	byte[] buffer = new byte[1024];
	int length;
	while ((length = in.read(buffer)) > 0) {
		out.write(buffer, 0, length);
	}
	out.close();
	in.close();
}
	
public void removeAbs(int absId) {
		
		absenceService.deleteAbsById(absId); }
	public EmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
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
	public Part getFile() {
		return file;
	}
	public void setFile(Part file) {
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
	
	public AbsenceService getAbsenceService() {
		return absenceService;
	}
	public void setAbsenceService(AbsenceService absenceService) {
		this.absenceService = absenceService;
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
