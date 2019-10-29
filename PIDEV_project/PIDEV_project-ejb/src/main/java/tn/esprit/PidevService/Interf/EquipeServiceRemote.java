package tn.esprit.PidevService.Interf;


import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.User;

@Remote
public interface EquipeServiceRemote {
	public int AddEquipe(Equipe equipe);
	public Equipe getEquipeById(int id);
	public List<Equipe> getAllEquipes();
	public void UpdateEquipe(Equipe equipe);
	public int AssignUserTo(Equipe equipe , User user);
	public int UnAssignUser(User user);
}