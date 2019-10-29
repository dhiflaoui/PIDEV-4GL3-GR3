package tn.esprit.PidevService.Interf;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.User;

@Local
public interface EmployeServiceLocal {
	public int ajouterUser(User u);
	public void updateUser(User u);
	public void deleteUserById(int userId);


	

}
