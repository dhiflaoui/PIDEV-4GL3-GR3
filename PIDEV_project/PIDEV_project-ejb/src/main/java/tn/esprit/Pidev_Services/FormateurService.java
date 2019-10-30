package tn.esprit.Pidev_Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import tn.esprit.Pidev_Entities.Formation;
import tn.esprit.Pidev_Entities.User;
import tn.esprit.Pidev_Entities.Disponible;
import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Interfaces.IFormateurServiceRemote;
@Stateless
@LocalBean
public class FormateurService implements IFormateurServiceRemote{

	@PersistenceContext
	EntityManager em;
@Override
	public void modifierFormateur(Formateur f) {
		em.merge(f);		
	}


@Override
	public void SupprimerFormateur(int formateurId) {
		Formateur e = em.find(Formateur.class,formateurId);
		em.remove(e);
		
	}

@Override
public List<Formateur> getAllFormateursDis() {
	TypedQuery<Formateur> emp = em.createQuery("SELECT f FROM Formateur f WHERE f.dis =:x", Formateur.class);
			emp.setParameter("x", Disponible.oui);
			
			
			List<Formateur> results = emp.getResultList();
			return results; }
@Override
public List<Formateur> getAllFormateurs() {
	TypedQuery<Formateur> emp = em.createQuery("SELECT f FROM Formateur f ", Formateur.class);
			
			
			List<Formateur> results = emp.getResultList();
			return results; }

@Override
public List<User> getAllUsers() {
	TypedQuery<User> emp = em.createQuery("SELECT f FROM User f ", User.class);
			
			
			List<User> results = emp.getResultList();
			return results; }


		

		@Override
		public Formateur getFormateurById(int formateurId) 
		{
			Formateur emp = em.find(Formateur.class, formateurId);
			return  emp;
		}
		
		@Override
		public User getUserById(int formateurId) 
		{
			User emp = em.find(User.class, formateurId);
			return  emp;
		}

		
		@Override
		public List<Formateur> formateursDisponibleEtMemeSpecialite(Formateur format) {

			TypedQuery<Formateur> query = em.createQuery(
					"SELECT f FROM Formateur f WHERE f.dis =:x", Formateur.class);
			query.setParameter("x", Disponible.oui);

			List<Formateur> results = query.getResultList();
			return results;
		}
		
	 @Override
	 public int ajouterFormateur(Formateur f) {
		 		 em.persist(f);
	 		return f.getId();}


	@Override
	public void affecterFormateur(int idFormateur, int idFormation) {
		// TODO Auto-generated method stub
		
	}
	
}