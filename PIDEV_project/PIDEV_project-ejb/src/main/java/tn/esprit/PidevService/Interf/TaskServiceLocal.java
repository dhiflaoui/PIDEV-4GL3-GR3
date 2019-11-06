package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.*;

@Local
public interface TaskServiceLocal {
	public int AddTask(Project project,Task task);
	public Task getTasksById(int id);
	public Task getTaskByUser(User user);
	public List<Task>getTasksByProject(Project project);
	public void UpdateTask(Task task);
}