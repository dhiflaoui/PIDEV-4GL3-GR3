package managedbeans;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.Pidev_Entities.ABS_Etat;
import tn.esprit.Pidev_Entities.Role;
import tn.esprit.Pidev_Entities.Specialite;


@ManagedBean(name = "data") 
@ApplicationScoped
public class Data implements Serializable {
private static final long serialVersionUID = 1L;
public Role[] getRoles() 
{ 
	return Role.values(); 
}
public ABS_Etat[] getABS_Etat()
{
	return ABS_Etat.values();
			}
public Specialite[] getSpecialites()
{
	return Specialite.values();
			}

}

