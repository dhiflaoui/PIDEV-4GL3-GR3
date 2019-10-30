package tn.esprit.Pidev_Services;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import tn.esprit.Pidev_Entities.Formation;
import tn.esprit.Pidev_Entities.User;
import tn.esprit.Pidev_Interfaces.IFormationServiceRemote;

@Stateless
@LocalBean
public class FormationService implements IFormationServiceRemote {
	@PersistenceContext
	EntityManager em;

	public int ajouterFormation(Formation fo) {
		
		em.persist(fo);
 		return fo.getId();
	}

	@Override
	public void modifierFormation(Formation fo) {
		em.merge(fo);

	}
	@Override
	public void modifierUser(User u) {
		em.merge(u);

	}

	@Override
	public void SupprimerFormation(int formationId) {
		Formation e = em.find(Formation.class,formationId);
		em.remove(e);
	}

	@Override
	public List<Formation> getAllFormation() {
		List<Formation> emp = em.createQuery("Select e from Formation e", Formation.class).getResultList();
		return emp; }

	
@Override
public Formation getFormationById(int idFormation) {
	return em.find(Formation.class, idFormation);
}
}




