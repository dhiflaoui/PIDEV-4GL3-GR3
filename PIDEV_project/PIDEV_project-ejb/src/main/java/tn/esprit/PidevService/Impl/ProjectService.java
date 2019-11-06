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
public class ProjectService implements ProjectServiceRemote ,ProjectServiceLocal {
	
	@PersistenceContext
	EntityManager em;
	
	
	public int AddProject(Project project,User user)
	{	
		project.setOwnedBy(user);
		user.getOwnerOF().add(project);
		em.persist(project);
		em.merge(user);
 		return project.getId();
	}
//----------------------------------------------------------------------------	
	
	
	public Project getProjectById(int id) {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.id=:id", Project.class);
		query.setParameter("id", id);
		Project project = null;
		try { project = query.getSingleResult(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return project;
	}
	
	
	public List<Project> getAllProjects() {
		List<Project> project = em.createQuery("Select p from Project p", Project.class).getResultList();
		return project;
		}
	
	public List<Project> getProjectByOwner(User user) {
		TypedQuery<Project> query = em.createQuery("select p from Project p where p.ownedBy=:id", Project.class);
		query.setParameter("id", user.getId());
		List<Project> projects = null;
		try { projects = query.getResultList(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return projects;
	}
	
	
	public void UpdateProject(Project project) 
	   {
		em.merge(project); 
		}
	
	public void AssignUserTo(Equipe equipe , User user) {
		if (user.getMemberOf() == null || user.getMemberOf()==equipe){
			 System.out.println("Erreur");
		}
		else
		{
			equipe.getMembers().add(user);
			em.merge(equipe);
		}
	}
	
	public void UnAssignUser(User user) {
		if (user.getMemberOf() == null){
			 System.out.println("Erreur");
		}
		else
		{
			user.setMemberOf(null);;
			em.merge(user);
		}
	}

}
