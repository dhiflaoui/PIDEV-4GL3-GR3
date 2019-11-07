package tn.esprit.PidevService.Interf;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.Conge;
@Local
public interface CongeServiceLocal {
	public void demandeConge(Conge c);
	public void updateConge(Conge e) ;


}
