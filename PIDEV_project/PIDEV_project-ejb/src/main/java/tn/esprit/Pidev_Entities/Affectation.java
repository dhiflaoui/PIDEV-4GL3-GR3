package tn.esprit.Pidev_Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Affectation implements Serializable {

	
	public Affectation() {
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="Id_Affectation")
	private int Id ;
	
	@ManyToOne
	private Formation formations;
	
	@ManyToOne
	private  User users;
	
	@Column(name="Score")
	private Integer score ;

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

	public Affectation(int id,  Integer score) {
		super();
		Id = id;
			this.score = score;
	}

	@Override
	public String toString() {
		return "Affectation [Id=" + Id + ", formations=" + formations + ", users=" + users + ", score=" + score + "]";
	}

	
	
}
