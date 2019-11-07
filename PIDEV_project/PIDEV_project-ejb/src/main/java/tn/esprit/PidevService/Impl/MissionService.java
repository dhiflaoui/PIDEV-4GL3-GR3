package tn.esprit.PidevService.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.PidevService.Interf.MissionLocalService;
import tn.esprit.PidevService.Interf.MissionRemoteService;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.Mission;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Entities.User;



@Stateless
@LocalBean
public class MissionService extends BaseEntityService<Mission> implements MissionLocalService, MissionRemoteService {
	
	
	public MissionService() {
		super(Mission.class);
	}

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public Long addMission(Mission m) {
		em.persist(m);
		return m.getId();

	}

	@Override
	public void deleteMission(Long id) {
		em.remove(em.find(Mission.class, id));
	}

	@Override
	public void updateMission(Mission m) {
		em.merge(m);

	}

	/*
	 * @Override public List<Mission> getMissionById(Long id) { TypedQuery<Mission>
	 * query = em.createQuery("SELECT m FROM Mission m where m.id=" + id,
	 * Mission.class); List<Mission> list = new ArrayList<>(); list =
	 * query.getResultList(); return list; }
	 */
	
	@Override
	public List<Mission> getAllMission() {
		TypedQuery<Mission> query = em.createQuery("SELECT m FROM Mission m", Mission.class);
		List<Mission> list = new ArrayList<>();
		list = query.getResultList();
		return list;
	}
	
	public List<User> getAllUserSpecialite(String specialite) {
		TypedQuery<User> query = em.createQuery("SELECT User.prenom,User.Specialite from User where User.Specialite=:x ", User.class);
		query.setParameter("x", specialite);
		List<User> list = new ArrayList<>();
		list = query.getResultList();
		return list;
	}
	
	
	
	
	

	public Mission getMissionById(Long id) {

		TypedQuery<Mission> query = em.createQuery("select m from Mission m where m.id=:id", Mission.class);

		query.setParameter("id", id);

		Mission mission = null;
		try {
			mission = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}

		return mission;
	}

	@Override
	public void participate(Long id, User employee) {
		final Mission mission = getMissionById(id);
		//mission.setparticipant(employee);
		em.persist(mission);
	}

	
	public List<Mission> mesMission(Specialite idEmployee) {
		TypedQuery<Mission> query = em.createQuery("SELECT m FROM Mission m WHERE m.spesialite =:x", Mission.class);
		query.setParameter("x", em.find(User.class, idEmployee));
		List<Mission> results = query.getResultList();
		return results;
	}

	
	
	

}
