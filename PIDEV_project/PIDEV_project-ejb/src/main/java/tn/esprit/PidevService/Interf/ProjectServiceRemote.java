package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.*;

@Remote
public interface ProjectServiceRemote {
	public int AddProject(Project project);
	public void removeProject(int pid);
	public Project getProjectById(int id);
	public List<Project> getProjectByOwner(User user);
	public List<Project> getAllProjects();
	public void UpdateProject(Project project);
	public void finishProject(int pid);
	public List<Project> getPendingProjects();
	public List<Project> getOnGoingProjects();
	public List<Project> getFinishedProjects();
}