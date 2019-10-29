package tn.esprit.PidevService.Interf;


import javax.ejb.Local;

import tn.esprit.Pidev_Entities.*;

@Local
public interface TaskServiceRemote {
	public int AddTask(Project project,Task task);
	public Task getTasksById(int id);
	public Task getTaskByUser(User user);
	public List<Tasks>getTasksByProject(Project project);
	public void UpdateTask(Task task);
}