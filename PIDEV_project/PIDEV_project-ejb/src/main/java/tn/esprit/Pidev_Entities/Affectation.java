package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement

public class Affectation implements Serializable {

	
	public Affectation() {
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int Id ;
	
	@ManyToOne
	private Formation formations;
	
	@ManyToOne
	private  User users;
	
	@Column(name="Score")
	private Integer score ;
	
	@Column(name="Montion")
	private String montion ;

	public String getMontion() {
		return montion;
	}

	public Affectation(int id, Formation formations, User users, Integer score, String montion) {
		super();
		Id = id;
		this.formations = formations;
		this.users = users;
		this.score = score;
		this.montion = montion;
	}

	public void setMontion(String montion) {
		this.montion = montion;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Formation getFormations() {
		return formations;
	}

	public void setFormations(Formation formations) {
		this.formations = formations;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Affectation( Integer score) {
		super();
		
		this.score = score;
	}

	

	public Affectation(int id, Integer score, String montion) {
		super();
		Id = id;
		
	}

	@Override
	public String toString() {
		return "Affectation [Id=" + Id + ", formations=" + formations + ", users=" + users + ", score=" + score + "]";
	}

	
	
}
