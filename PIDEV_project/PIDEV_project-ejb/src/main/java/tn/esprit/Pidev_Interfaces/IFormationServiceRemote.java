package tn.esprit.Pidev_Interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Formation;
@Remote
public interface IFormationServiceRemote {
	public int ajouterFormation(Formation fo);
	public void modifierFormation(Formation fo);
	public void SupprimerFormation(int formationId );
	public List<Formation> getAllFormation() ;
	public Formation getFormationById(int idFormation);

}
