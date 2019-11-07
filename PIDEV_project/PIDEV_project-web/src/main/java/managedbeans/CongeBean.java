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
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import tn.esprit.PidevService.Impl.CongeService;
import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.Conge;
import tn.esprit.Pidev_Entities.Conge_Etat;
import tn.esprit.Pidev_Entities.Conge_Type;
import tn.esprit.Pidev_Entities.User;
import utils.Util;

@ManagedBean(name = "congeBean") 
@SessionScoped
public class CongeBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dateDebut ;
	private Date dateFin ;
	private Part file;
	private Conge_Type type; 
	@EJB
	CongeService congeService;
	@EJB
	EmployeService employeService;
	//-------------- Traitement semi-automatique------------------------ //
	public String demandeConge() throws IOException {

		User userC = LoginBean.getUser();
		Conge conge = new Conge(dateDebut, dateFin, type);
		conge.setUser(userC);
		conge.setEtat(Conge_Etat.En_Attente);
		if (file!=null) {
		conge.setFile(file.getSubmittedFileName());
		}
		int soldeConge = userC.getSolde_conge();
		Date dateD = dateDebut;
		Date dateF = dateFin;
		long diff = dateF.getTime() - dateD.getTime();
//		Date dateDMission = userC.getMission().getDateStart();
//		Date dateFMission = userC.getMission().getDateEnd(); 

		float res = (diff / (1000*60*60*24));
		System.out.println("Nombre de jours entre les deux dates est: "+res);

		int value = (int) res;
//
//		if ((type == Conge_Type.sans_solde || type==Conge_Type.simple || type==Conge_Type.été ) &&( (dateD.after(dateFMission)==false || (dateF.before(dateFMission)==false)) )) {
//			return "echec-demande-conge1?faces-redirect=true";
//
//		}
		 if ((type == Conge_Type.sans_solde || type==Conge_Type.simple || type==Conge_Type.été ) && (value > soldeConge) ) {
			return "echec-demande-conge?faces-redirect=true";

		}
		else if ((type == Conge_Type.sans_solde || type==Conge_Type.simple || type==Conge_Type.été )  && (value < soldeConge)) {
			congeService.demandeConge(conge);
				String folderName1 = Util.serverF;
				upload2(folderName1);
			
			return "succes-demande-conge?faces-redirect=true";
		}
		
		else {
			congeService.demandeConge(conge);

				String folderName1 = Util.serverF;
				upload2(folderName1);
			
			return "succes-demande-conge?faces-redirect=true";
		}

		

	}
	public String upload2(String folderName1) throws IOException {
		
		if (file != null) {
		
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
		return "succes-demande-conge?faces-redirect=true";


		}
		else {
			return "succes-demande-conge?faces-redirect=true";

			
		}

		
	}
	
	// ------------- Suivi Congé -------------- //
	public void setMesconges(List<Conge> mesconges) {
		this.mesconges = mesconges;
	}
	private List<Conge> mesconges;
	public List<Conge> getMesconges(){
		int a = LoginBean.getUser().getId();
		System.out.println("leeeeeeeeeeeeeeeeeeeeeeee"+a);
		mesconges = congeService.mesConge(a); 
		return mesconges;
	}
	// -----------------END---------------------//
	//------------Liste Congé RH-------------//
	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}
	private List<Conge> conges;
	public List<Conge> getConges(){
		conges = congeService.getAllConge(); 
		return conges;
	}
	
	
	//------------------END---------------------//
	//------------Accepte Algo solde congé - nbr de jour congé et etat en congé et sans solde - salaire-------------------//
	public void accepte(Conge item) {
		
		Date dateD = item.getDateDebut();
		Date dateF = item.getDateFin();
	    long diff = dateF.getTime() - dateD.getTime();
	    float res = (diff / (1000*60*60*24));
	    System.out.println("Nombre de jours entre les deux dates est: "+res);
	    int value = (int) res;
	    User user = item.getUser();
	    Double salaire =item.getUser().getSalaire();
	    Double fazaSalaire= (salaire/30) * value;
		int soldeConge =user.getSolde_conge();
		if (item.getType()==Conge_Type.maternité) {
			item.setEtat(Conge_Etat.Accepté);
			congeService.updateConge(item);
		}
		else if (item.getType()==Conge_Type.sans_solde) {
			item.setEtat(Conge_Etat.Accepté);
			congeService.updateConge(item);
			user.setSalaire(salaire - fazaSalaire);
			employeService.updateUser(user);
	
		}
		else {
			item.setEtat(Conge_Etat.Accepté);
			user.setSolde_conge(soldeConge-value);
			congeService.updateConge(item);
			employeService.updateUser(user);

		}
	}
	public void refuse(Conge item) {
		item.setEtat(Conge_Etat.Réfuser);
		congeService.updateConge(item);
		
	}
	//-------------------END-------------------//

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





	// ----------------------------//
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

	public Conge_Type getType() {
		return type;
	}
	public void setType(Conge_Type type) {
		this.type = type;
	}
	public CongeService getCongeService() {
		return congeService;
	}
	public void setCongeService(CongeService congeService) {
		this.congeService = congeService;
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



}
