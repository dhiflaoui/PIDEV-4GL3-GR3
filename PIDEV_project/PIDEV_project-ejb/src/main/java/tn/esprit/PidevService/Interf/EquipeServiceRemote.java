package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.*;

@Remote
public interface EquipeServiceRemote {
	public int AddEquipe(Equipe equipe, User user);
	public Equipe getEquipeById(int id);
	public List<Equipe> getAllEquipes();
	public void UpdateEquipe(Equipe equipe);
	public void AssignUserTo(Equipe equipe , User user);
	public void UnAssignUser(User user);
	
}