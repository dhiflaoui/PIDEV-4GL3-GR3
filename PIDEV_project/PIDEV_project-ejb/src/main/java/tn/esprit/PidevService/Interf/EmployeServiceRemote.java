package tn.esprit.PidevService.Interf;


import javax.ejb.Remote;

import tn.esprit.Pidev_Entities.User;

@Remote
public interface EmployeServiceRemote {
	public int ajouterUser(User u);
	public void updateUser(User u);

	public void deleteUserById(int userId);



}
