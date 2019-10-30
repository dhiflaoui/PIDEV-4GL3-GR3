package tn.esprit.Pidev_Interfaces;

import java.util.List;

import tn.esprit.Pidev_Entities.Affectation;

public interface IAffectationServiceRemote {
	public void modifierAffectation(Affectation f);
	public void SupprimerAffectation(int formateurId);
	public int ajouterAffectation(Affectation f);
	public List<Affectation> getAllAffectation() ;

}
