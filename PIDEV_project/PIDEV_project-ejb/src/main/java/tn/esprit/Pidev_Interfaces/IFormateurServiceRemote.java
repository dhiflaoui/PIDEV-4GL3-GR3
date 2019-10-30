package tn.esprit.Pidev_Interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Conge;
import tn.esprit.Pidev_Entities.Formateur;
import tn.esprit.Pidev_Entities.User;

@Remote
public interface IFormateurServiceRemote {
	public void modifierFormateur(Formateur f);
	public void SupprimerFormateur(int formateurId);
	public List<Formateur> getAllFormateurs() ;
	public Formateur getFormateurById(int formateurId);
	void affecterFormateur(int idFormateur, int idFormation);
	int ajouterFormateur(Formateur f);
	public List<Formateur> formateursDisponibleEtMemeSpecialite(Formateur format);
	public User getUserById(int formateurId);
	public List<User> getAllUsers();
	public List<Formateur> getAllFormateursDis();

}
