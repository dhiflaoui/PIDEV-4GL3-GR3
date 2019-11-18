package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.PidevService.Impl.ProjectService;
import tn.esprit.Pidev_Entities.Project;
import tn.esprit.Pidev_Entities.State;
import tn.esprit.Pidev_Entities.User;

@ManagedBean(name="projectBean")
@SessionScoped
public class ProjectBean implements Serializable {
    
	private int budget;
	private String clientName;
	private String title;
	private String description;
	private List<Project> projects;
	private List<Project> pendingProjects;
	private List<Project> onGoingProjects;
	private List<Project> finishedProjects;
	
	private int projectIdToUpdate;
	private int projectIdToManage;
	
	public int getProjectIdToManage() {
		return projectIdToManage;
	}


	public void setProjectIdToManage(int projectIdToManage) {
		this.projectIdToManage = projectIdToManage;
	}


	public List<Project> getFinishedProjects() {
		finishedProjects = ps.getFinishedProjects();
		return finishedProjects;
	}


	public void setFinishedProjects(List<Project> finishedProjects) {
		this.finishedProjects = finishedProjects;
	}


	public List<Project> getPendingProjects() {
		pendingProjects = ps.getPendingProjects();
		return pendingProjects;
	}


	public void setPendingProjects(List<Project> pendingProjects) {
		this.pendingProjects = pendingProjects;
	}


	public List<Project> getOnGoingProjects() {
		onGoingProjects = ps.getOnGoingProjects();
		return onGoingProjects;
	}


	public void setOnGoingProjects(List<Project> onGoingProjects) {
		this.onGoingProjects = onGoingProjects;
	}


	@EJB
	ProjectService ps ; 

	public String addProject() {
		System.out.println("test");
		int a = ps.AddProject(new Project(clientName,title,description,budget,State.Pending));
		System.out.println(a);
		return "new-project-added?faces-redirect=true";
	}

	
	
	public String remove(Project p) {
		ps.removeProject(p.getId());
		return "Project-Updated?faces-redirect=true";
	}
	
	
	public String finish(Project p) {
		ps.finishProject(p.getId());
		return "Project-Updated?faces-redirect=true";
	}
	
	public String manage(Project p) {
		this.setProjectIdToManage(p.getId());
		return "ProjectTasksList?faces-redirect=true";
	}
	
	public void modify(Project project) {
		this.setDescription(project.getDescription());;
		this.setClientName(project.getClientName());
		this.setTitle(project.getTitle());
		this.setBudget(project.getBudget());
		this.setProjectIdToUpdate(project.getId());
		}
	
	public void updateProject(){ 
		ps.UpdateProject(new Project(projectIdToUpdate,clientName,title,description,budget));}

	public String getClientName() {
		return clientName;
	}


	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ProjectBean() {
		
	}

	public int getBudget() {
		return budget;
	}



	public void setBudget(int budget) {
		this.budget = budget;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public ProjectService getPs() {
		return ps;
	}



	public void setPs(ProjectService ps) {
		this.ps = ps;
	}


	public List<Project> getProjects() {
		projects = ps.getAllProjects();
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public int getProjectIdToUpdate() {
		return projectIdToUpdate;
	}


	public void setProjectIdToUpdate(int projectIdToUpdate) {
		this.projectIdToUpdate = projectIdToUpdate;
	}
	

}