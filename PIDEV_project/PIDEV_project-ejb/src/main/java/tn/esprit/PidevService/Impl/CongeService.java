package tn.esprit.PidevService.Impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PidevService.Interf.CongeServiceLocal;
import tn.esprit.PidevService.Interf.CongeServiceRemote;
import tn.esprit.Pidev_Entities.Conge;

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
	

}
