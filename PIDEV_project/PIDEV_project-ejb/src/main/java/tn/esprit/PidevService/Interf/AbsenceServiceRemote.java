package tn.esprit.PidevService.Interf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.Absence;

@Remote
public interface AbsenceServiceRemote {
	public int addAbsence(Absence a);
	public void updateAbs(Absence e) ;
	public void deleteAbsById(int absId) ;
	public List<Absence> getAllAbs() ;

}
