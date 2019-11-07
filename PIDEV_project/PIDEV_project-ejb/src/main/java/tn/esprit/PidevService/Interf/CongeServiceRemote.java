package tn.esprit.PidevService.Interf;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Conge;


@Remote
public interface CongeServiceRemote {
	public void demandeConge(Conge c);

	public void updateConge(Conge e) ;

}
