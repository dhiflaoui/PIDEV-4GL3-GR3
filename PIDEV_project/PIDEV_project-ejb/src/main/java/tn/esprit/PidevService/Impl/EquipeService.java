package tn.esprit.PidevService.Impl;

import java.util.ArrayList;
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
public class EquipeService implements EquipeServiceRemote ,EquipeServiceLocal {
	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;
	
	
	@Override
	 public int AddEquipe(Equipe equipe , User user)
	{	
		if(user.getManagerOf() == null){
			List<Equipe> equipes = new ArrayList<>();
			equipes.add(equipe);
			user.setManagerOf(equipes);
		}else{
			user.getManagerOf().add(equipe);		
			}
		em.merge(user);
		return equipe.getId();

	}
	
	public Equipe getEquipeById(int id) {
		TypedQuery<Equipe> query = em.createQuery("select e from Equipe e where e.id=:id", Equipe.class);
		query.setParameter("id", id);
		Equipe equipe = null;
		try { equipe = query.getSingleResult(); }
		catch (Exception

		e) { System.out.println("Erreur : " +
		e); }

		return equipe;
	}
	
	
	public List<Equipe> getAllEquipes() {
		List<Equipe> eqp = em.createQuery("Select e from Equipe e", Equipe.class).getResultList();
		return eqp; }
	
	
	public void UpdateEquipe(Equipe equipe) {
		em.merge(equipe); 
		}
	
	public void AssignUserTo(Equipe equipe , User user) {
		if (user.getMemberOf()== null || user.getMemberOf() == equipe){
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
