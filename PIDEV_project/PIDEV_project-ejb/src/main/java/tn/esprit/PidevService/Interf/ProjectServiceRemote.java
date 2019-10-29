package tn.esprit.PidevService.Interf;


import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.*;

@Remote
public interface ProjectServiceRemote {
	public int AddProject(Project project,User user);
	public Project getProjectById(int id);
	public Project getProjectByOwner(User user);
	public List<Project> getAllProjects();
	public void UpdateProject(Project project);
}