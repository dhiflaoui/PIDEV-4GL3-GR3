package managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.Part;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.Pidev_Entities.Role;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Entities.User;
import utils.Util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


@ManagedBean(name = "userBean") 
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nom;
	private String cin;

	private String prenom;
	private String motdp;  
	private String adresseMail; 
	private Part photo;

	private Part cv;

	public int getSolde_absence() {
		return solde_absence;
	}

	public void setSolde_absence(int solde_absence) {
		this.solde_absence = solde_absence;
	}
	private String ville;
	private String tel;
	private User user;
	private int solde_conge;
	private int solde_absence;

	private Double salaire;
	private Role role; 
	private Specialite specialite;
	private Integer userIdToBeUpdated;
	
	

	@EJB EmployeService employeService; 
	public String addEmploye() throws IOException {
		employeService.ajouterUser(new User( cin,  nom,  prenom,  adresseMail,  motdp,  photo.getSubmittedFileName(),
				 cv.getSubmittedFileName(),  ville,  tel,  solde_conge, solde_absence, salaire,  role, specialite)); 
		String folderName1 = Util.serverF;
		String folderName = Util.serverI;

		uploadCv(folderName1);
		upload2(folderName);

		return "succes-ajout-employe?faces-redirect=true";
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
	//	this.setCv(user.getCv().);
	//	this.setPhoto(user.getPhoto()); 
		this.setTel(user.getTel()); 
		this.setSolde_conge(user.getSolde_conge()); 
		this.setSolde_absence(user.getSolde_absence()); 

		this.setSalaire(user.getSalaire()); 

		this.setUserIdToBeUpdated(user.getId()); }
	
	
	
	public void mettreAjourUser(){ 
		employeService.updateUser(new User(userIdToBeUpdated, cin,  nom,  prenom,  adresseMail,  motdp,  ville,  tel,  solde_conge,solde_absence,  salaire,  role, specialite)); }
public void removeEmploye(int employeId) {
		
		employeService.deleteUserById(employeId); }



public void upload2(String folderName) throws IOException {
	InputStream in = photo.getInputStream();
	File f = new File(folderName + "\\" + photo.getSubmittedFileName());
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
public void uploadCv(String folderName1) throws IOException {
	InputStream in1 = cv.getInputStream();
	File f1 = new File(folderName1 + "\\" + cv.getSubmittedFileName());
	f1.createNewFile();
	FileOutputStream out1 = new FileOutputStream(f1);
	byte[] buffer1 = new byte[1024];
	int length1;
	while ((length1 = in1.read(buffer1)) > 0) {
		out1.write(buffer1, 0, length1);
	}
	out1.close();
	in1.close();
}
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
	public Part getPhoto() {
		return photo;
	}
	public void setPhoto(Part photo) {
		this.photo = photo;
	}
	public Part getCv() {
		return cv;
	}
	public void setCv(Part cv) {
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	} 
	
	
	
}