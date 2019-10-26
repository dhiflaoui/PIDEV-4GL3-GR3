package tn.esprit.PidevService.Impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import tn.esprit.PidevService.Interf.EmployeServiceLocal;
import tn.esprit.PidevService.Interf.EmployeServiceRemote;
import tn.esprit.Pidev_Entities.User;


@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote ,EmployeServiceLocal {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public int ajouterUser(User user) 
	{	
		em.persist(user);
 		return user.getId();
	}
	
	public User getUserByEmailAndPassword(String cin, String motdp) {
		TypedQuery<User> query = em.createQuery("select e from User e where e.cin=:cin AND e.motdp=:motdp", User.class);
		query.setParameter("cin", cin);
		query.setParameter("motdp", motdp);
		User user = null;
		try { user = query.getSingleResult(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return user;
		}
	public List<User> getAllUser() {
		List<User> emp = em.createQuery("Select e from User e", User.class).getResultList();
		return emp; }
	public void deleteUserById(int userId) {
		User e = em.find(User.class,userId);
		em.remove(e);
		}
	public void updateUser(User e) { 
		em.merge(e); 
		
		}
	
}
