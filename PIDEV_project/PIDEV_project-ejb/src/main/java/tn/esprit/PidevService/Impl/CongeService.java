package tn.esprit.PidevService.Impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PidevService.Interf.CongeServiceLocal;
import tn.esprit.PidevService.Interf.CongeServiceRemote;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.Conge;
import tn.esprit.Pidev_Entities.User;

@Stateless
@LocalBean
public class CongeService implements CongeServiceRemote ,CongeServiceLocal {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void demandeConge(Conge conge) 
	{	
		em.persist(conge);
	}
	public List<Conge> getAllConge() {
		List<Conge> emp = em.createQuery("Select a from Conge a", Conge.class).getResultList();
		return emp; }
	public List<Conge> mesConge(int idEmployee) {
		TypedQuery<Conge> query = em.createQuery("SELECT m FROM Conge m WHERE m.user =:x", Conge.class);
		query.setParameter("x", em.find(User.class, idEmployee));

		List<Conge> results = query.getResultList();
		return results;
	}
	public void updateConge(Conge e) { 
		em.merge(e); 
		
		}
	

}
