package managedbeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.PidevService.Impl.ProjectService;
import tn.esprit.PidevService.Impl.TaskService;
import tn.esprit.Pidev_Entities.Project;
import tn.esprit.Pidev_Entities.Task;


@ManagedBean(name="taskBean")
@SessionScoped
public class TaskBean implements Serializable {

	@EJB
	TaskService ts; 
	
	@EJB
	ProjectService ps; 
	
	@ManagedProperty(value="#{project}")
	private ProjectBean projectBean;
	
	private String title;
	private String description;
	private String spec;
	private int duration;
	private int taskIdToUpdate;
	private List<Task> tasks;
	private Project project;
	
	public TaskBean() {
		super();

	}

	public TaskService getTs() {
		return ts;
	}

	public void setTs(TaskService ts) {
		this.ts = ts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}


	public int getTaskIdToUpdate() {
		return taskIdToUpdate;
	}

	public void setTaskIdToUpdate(int taskIdToUpdate) {
		this.taskIdToUpdate = taskIdToUpdate;
	}

	public List<Task> getTasks() {
		System.out.println("get shit /////////////////////////////////");
		System.out.println(projectBean.getProjectIdToManage());
		return ts.getTasksByProject(ps.getProjectById(projectBean.getProjectIdToManage()));
		
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public void setProjectBean(ProjectBean projectBean) {
		this.projectBean = projectBean;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

}