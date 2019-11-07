package managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.PidevService.Impl.MissionService;
import tn.esprit.Pidev_Entities.Absence;
import tn.esprit.Pidev_Entities.Mission;
import tn.esprit.Pidev_Entities.Specialite;
import tn.esprit.Pidev_Entities.User;

@ManagedBean(name = "MissionBean")
@SessionScoped
public class MissionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;
	private Specialite specialite;

	private String dateStart;
	private Long missionIdToBeUpdated;
	private String dateEnd;
	private String location;
	
	private List<Mission> mission;
	private List<Mission> missionn;

	private Long IdMission;

	private List<User> employeesForSpecialiteList;

	@EJB
	MissionService missionService;
	@EJB
	EmployeService employeService;

	public String getName() {
		return name;
	}

	
	
	
	public String getDateStart() {
		return dateStart;
	}




	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}




	public String getDateEnd() {
		return dateEnd;
	}




	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}




	public String getLocation() {
		return location;
	}




	public Long getMissionIdToBeUpdated() {
		return missionIdToBeUpdated;
	}




	public void setMissionIdToBeUpdated(Long missionIdToBeUpdated) {
		this.missionIdToBeUpdated = missionIdToBeUpdated;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	@PostConstruct
	public void init() {
		this.employeesForSpecialiteList = new ArrayList<>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Mission> getMission() {
		mission = missionService.getAllMission();
		return mission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Specialite getSpecialite() {
		return specialite;
	}

	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}

	public void addMission() {
		Mission m = new Mission(name, description, specialite,location,dateStart,dateEnd);
		missionService.addMission(m);
	}

	public void removeMission(Long id) {
		missionService.deleteMission(id);
	}

	
	
	
	public void update(Mission mission) {
		this.setName(mission.getName());
		this.setDescription(mission.getDescription());
		this.setDateEnd(mission.getDateEnd());
		this.setDateStart(mission.getDateStart());
		this.setLocation(mission.getLocation());
		this.setSpecialite(mission.getSpecialite());
		this.setMissionIdToBeUpdated(mission.getId()); 
	}
	

	public void getEmployeesForSpecialite(ValueChangeEvent event) {
		List<User> allUsersList = employeService.getAllUser();

		List<User> filteredUsersList = allUsersList.stream().filter(user -> user.getSpecialite().equals(specialite)).collect(Collectors.toList());
		if (filteredUsersList.isEmpty())
			employeesForSpecialiteList.clear();
		else
			employeesForSpecialiteList = filteredUsersList;

	}
	
	
	public List<User> getEmployeesForSpecialiteList() {
		return employeesForSpecialiteList;
	}

	public void setEmployeesForSpecialiteList(List<User> employeesForSpecialiteList) {
		this.employeesForSpecialiteList = employeesForSpecialiteList;
	}
	

	public void updateMissionn(){ 
		missionService.updateMission(new Mission(missionIdToBeUpdated, name,description, location, dateStart,dateEnd,specialite));
		
	}
	
	/*public List<Mission> getMesMissions(){
		int a = LoginBean.getUser().getId();
		System.out.println("leeeeeeeeeeeeeeeeeeeeeeee"+a);
		missionn = missionService.mesMission(); 
		return missionn;
	}*/
	

}