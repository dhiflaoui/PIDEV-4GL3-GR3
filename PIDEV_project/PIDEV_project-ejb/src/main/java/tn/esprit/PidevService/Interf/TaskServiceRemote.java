package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.*;

@Remote
public interface TaskServiceRemote {
	public int AddTask(Project project,Task task);
	public Task getTasksById(int id);
	public Task getTaskByUser(User user);
	public List<Task>getTasksByProject(Project project);
	public void UpdateTask(Task task);
}