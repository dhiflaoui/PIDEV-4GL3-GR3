package tn.esprit.PidevService.Impl;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.PidevService.Interf.AbsenceServiceLocal;
import tn.esprit.PidevService.Interf.AbsenceServiceRemote;
import tn.esprit.Pidev_Entities.Absence;

@Stateless
@LocalBean
public class AbsenceService implements AbsenceServiceRemote ,AbsenceServiceLocal {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void addAbsence(Absence absence) 
	{	
		em.persist(absence);
	}
	
	

}
