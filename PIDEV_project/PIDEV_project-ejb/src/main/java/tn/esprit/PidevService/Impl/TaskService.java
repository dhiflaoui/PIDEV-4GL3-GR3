package tn.esprit.PidevService.Impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PidevService.Interf.*;
import tn.esprit.Pidev_Entities.*;


@Stateless
@LocalBean
public class TaskService implements TaskServiceRemote ,TaskServiceLocal {
	
	@PersistenceContext
	EntityManager em;
	
	
	public int AddTask(Project project,Task task)
	{	
		project.getTasks().add(task);
		task.setProject(project);
		em.persist(task);
		em.merge(project);
 		return task.getId();
 	
	}
	
	

	public Task getTasksById(int id){
		TypedQuery<Task> query = em.createQuery("select t from Task t where t.id=:id", Task.class);
		query.setParameter("id", id);
		Task task = null;
		try { task = query.getSingleResult(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return task;
	}
			
	public List<Project> getAllProjects() {
		List<Project> project = em.createQuery("Select p from Project p", Project.class).getResultList();
		return project;
		}
	
	public Task getTaskByUser(User user) {
	//	TypedQuery<Task> query = em.createQuery("", Project.class);
	//	query.setParameter("id", user.id);
	//	List<Project> projects = null;
	//	try { projects = query..getResultList(); }
	//	catch (Exception

	//	e) { System.out.println("Erreur : " +
	//	e); }

	//	return projects;
		return null ;
	}
	
	public List<Task>getTasksByProject(Project project){
         	TypedQuery<Task> query = em.createQuery("select task t join t.project e where e.id=:id", Task.class);
			query.setParameter("id", project.getId());
			List<Task> tasks = null;
			try { tasks = query.getResultList(); }
			catch (Exception

			e) { System.out.println("Erreur : " +
			e); }

			return tasks;
	}

	
	
	public void UpdateTask(Task task){
		em.merge(task); 
		}

}
