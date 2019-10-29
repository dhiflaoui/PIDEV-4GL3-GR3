package tn.esprit.PidevService.Impl;

import java.util.List;

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
	public int addAbsence(Absence absence) 
	{	
		em.persist(absence);
 		return absence.getId();

	}
	
	public List<Absence> getAllAbs() {
		List<Absence> emp = em.createQuery("Select a from Absence a", Absence.class).getResultList();
		return emp; }
	public void deleteAbsById(int absId) {
		Absence e = em.find(Absence.class,absId);
		em.remove(e);
		}
	public void updateAbs(Absence e) { 
		em.merge(e); 
		
		}
	
	
	

}
