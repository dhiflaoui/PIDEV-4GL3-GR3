package tn.esprit.PidevService.Interf;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.Absence;

@Local
public interface AbsenceServiceLocal  {
	public int addAbsence(Absence a);
	public void updateAbs(Absence e) ;
	public void deleteAbsById(int absId) ;
	public List<Absence> getAllAbs() ;


}
