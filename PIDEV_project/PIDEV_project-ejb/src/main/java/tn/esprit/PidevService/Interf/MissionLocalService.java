package tn.esprit.PidevService.Interf;


import java.util.List;

import javax.ejb.Local;

import tn.esprit.Pidev_Entities.Mission;
import tn.esprit.Pidev_Entities.User;
@Local
public interface MissionLocalService {
	public Long addMission(Mission m);
	public void deleteMission(Long id);
	public void updateMission(Mission m);
	public Mission getMissionById(Long id);
	public List<Mission> getAllMission();
	public void participate(Long id, User employee);
}
