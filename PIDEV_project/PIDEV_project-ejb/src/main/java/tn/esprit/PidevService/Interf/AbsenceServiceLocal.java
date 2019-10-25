package tn.esprit.PidevService.Interf;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.Absence;

@Local
public interface AbsenceServiceLocal  {
	public void addAbsence(Absence a);


}
