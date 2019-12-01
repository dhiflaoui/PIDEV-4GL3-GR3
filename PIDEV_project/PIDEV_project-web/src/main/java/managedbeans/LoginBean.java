package managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.Pidev_Entities.Role;
import tn.esprit.Pidev_Entities.User;



@ManagedBean(name="loginBean") 
@SessionScoped
public class LoginBean implements Serializable {

	private String cin; 
	private String motdp; 
	private static User user; 
	private User userLoggedIn;
	private Boolean loggedIn;

	@EJB
	EmployeService employeService; 

	public String doLogin()
	{
		String navigateTo = "null"; 
		 userLoggedIn = employeService.getUserByEmailAndPassword(cin, motdp); 
		if (userLoggedIn != null && userLoggedIn.getRole() == Role.RH) {
user = userLoggedIn;
			navigateTo = "/UsersListe?faces-redirect=true";
			System.out.println("leeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+user.getNom());
			loggedIn = true; 
		}
		else if (userLoggedIn != null && userLoggedIn.getRole() == Role.INGENIEUR || userLoggedIn.getRole() == Role.MANAGER || userLoggedIn.getRole() == Role.ADMINISTRATEUR || userLoggedIn.getRole() == Role.TECHNICIEN  ) {
user = userLoggedIn;
			navigateTo = "/Mes_Absence?faces-redirect=true";
			System.out.println("leeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+user.getNom());

			loggedIn = true; 
			
		}
		
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}

	public User getUserLoggedIn() {
		return userLoggedIn;
	}

	public void setUserLoggedIn(User userLoggedIn) {
		this.userLoggedIn = userLoggedIn;
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
 
	public LoginBean() {}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getMotdp() {
		return motdp;
	}

	public void setMotdp(String motdp) {
		this.motdp = motdp;
	}

	public static User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	
	
	
	
}

	
	
