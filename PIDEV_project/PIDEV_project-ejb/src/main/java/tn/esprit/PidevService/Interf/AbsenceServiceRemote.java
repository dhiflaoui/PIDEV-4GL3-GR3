package tn.esprit.PidevService.Interf;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Absence;

@Remote
public interface AbsenceServiceRemote {
	public void addAbsence(Absence a);


}
