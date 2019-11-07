package managedbeans;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
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
	public String justifiéClient(Absence item) throws IOException {
		System.out.println("nn354546546546454654654654nnnnnnnnnnnnnoooooooooooooooooooooooo");
		item.setEtat(ABS_Etat.en_cour_de_traitement);
		item.setFile(file.getSubmittedFileName());
		absenceService.updateAbs(item);
		String folderName1 = Util.serverF;
		upload2(folderName1);
		return "succes-justifie-absence?faces-redirect=true";

		
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
				+ ", je vous adresse ce courrier pour vous informer que vous marquer absent et si votre absence ne sera pas justifiée votre salaire sera deminué par 3% pour chaque jour .\r\n"
				+"pour justifier votre absence accéder à notre application et envoyer notre un rapport où une certifie qui explique votre absence\r\\n"
				+ "Pour plus de détails, veuillez contacter votre Service RH.\r\n" + "\r\n" + "Bien cordialement\r\n"
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
	item.setDecision("Votre Salaire est diminué par "+((salaire * 0.3*value)/100)+ "par jour(s)");
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
	//-------------------------------------------------Telechager CV-----------------------------------------//
	//Constants ----------------------------------------------------------------------------------

	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	// Actions ------------------------------------------------------------------------------------

	public void downloadPDF() throws IOException {

	    // Prepare.
	    FacesContext facesContext = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = facesContext.getExternalContext();
	    HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		String pathD = Util.serverD;
	String faza = "Chapitre 1- Introduction.pdf";
	    File file = new File(pathD,faza);
	    BufferedInputStream input = null;
	    BufferedOutputStream output = null;

	    try {
	        // Open file.
	        input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);

	        // Init servlet response.
	        response.reset();
	        response.setHeader("Content-Type", "application/pdf");
	        response.setHeader("Content-Length", String.valueOf(file.length()));
	        response.setHeader("Content-Disposition", "inline; filename=\"" + faza + "\"");
	        output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

	        // Write file contents to response.
	        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
	        int length;
	        while ((length = input.read(buffer)) > 0) {
	            output.write(buffer, 0, length);
	        }

	        // Finalize task.
	        output.flush();
	    } finally {
	        // Gently close streams.
	        close(output);
	        close(input);
	    }

	    // Inform JSF that it doesn't need to handle response.
	    // This is very important, otherwise you will get the following exception in the logs:
	    // java.lang.IllegalStateException: Cannot forward after response has been committed.
	    facesContext.responseComplete();
	}

	// Helpers (can be refactored to public utility class) ----------------------------------------

	public static int getDefaultBufferSize() {
		return DEFAULT_BUFFER_SIZE;
	}

	private static void close(Closeable resource) {
	    if (resource != null) {
	        try {
	            resource.close();
	        } catch (IOException e) {
	            // Do your thing with the exception. Print it, log it or mail it. It may be useful to 
	            // know that this will generally only be thrown when the client aborted the download.
	            e.printStackTrace();
	        }
	    }
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
