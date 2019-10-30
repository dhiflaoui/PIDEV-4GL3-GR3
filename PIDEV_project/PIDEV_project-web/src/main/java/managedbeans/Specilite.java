package managedbeans;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.Pidev_Entities.Disponible;
import tn.esprit.Pidev_Entities.Specialite;

@ManagedBean(name ="specilite")
@ApplicationScoped
public class Specilite implements Serializable {
private static final long serialVersionUID = 1L ;
	public Specialite[] getSpecialites() 
	

	{return Specialite.values();}
	public Disponible[] getDisp()
	{return Disponible.values();}

}
