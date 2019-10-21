package managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;



/*@ManagedBean(name="loginBean") 
@SessionScoped
public class LoginBean implements Serializable {
	
	private String login; 
	private String password; 
	//private Employe employe; 
	private Boolean loggedIn;

	@EJB
	//EmployeService employeService; 

	public String doLogin()
	{
		String navigateTo = "null"; 
		//employe = employeService.getEmployeByEmailAndPassword(login, password); 

		/*if (employe != null && employe.getRole() == Role.ADMINISTRATEUR) {
			navigateTo = "/pages/admin/welcome?faces-redirect=true";
			loggedIn = true; 
		}
		else 
		{
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}
		return navigateTo; 
	}

	public String doLogout()
	{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}
 
	public LoginBean() {} 
	
	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public Employe getEmploye() {return employe;}
	public void setEmploye(Employe employe) {this.employe = employe;}
	public Boolean getLoggedIn() {return loggedIn;}
	public void setLoggedIn(Boolean loggedIn) {this.loggedIn = loggedIn;}

}

	
	
}*/