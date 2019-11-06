package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.*;

@Local
public interface EquipeServiceLocal {
	public int AddEquipe(Equipe equipe, User user);
	public Equipe getEquipeById(int id);
	public List<Equipe> getAllEquipes();
	public void UpdateEquipe(Equipe equipe);
	public void AssignUserTo(Equipe equipe , User user);
	public void UnAssignUser(User user);
	
}