package tn.esprit.Pidev_Services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.Pidev_Entities.Affectation;
import tn.esprit.Pidev_Entities.Disponible;
import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Interfaces.IAffectationServiceRemote;

@Stateless
@LocalBean
public class AffectationService implements IAffectationServiceRemote {
	@PersistenceContext
	EntityManager em;
	@Override
	public void modifierAffectation(Affectation f) {
		em.merge(f);		
	}

	@Override
	public void SupprimerAffectation(int formateurId) {
		Affectation e = em.find(Affectation.class,formateurId);
		em.remove(e);
	}

	@Override
	public int ajouterAffectation(Affectation f) {
		em.persist(f);
 		return f.getId();
	}

	@Override
	public List<Affectation> getAllAffectation() {
		TypedQuery<Affectation> emp = em.createQuery("SELECT f FROM Affectation f ", Affectation.class);
		
		
		List<Affectation> results = emp.getResultList();
		return results;
	}

}
