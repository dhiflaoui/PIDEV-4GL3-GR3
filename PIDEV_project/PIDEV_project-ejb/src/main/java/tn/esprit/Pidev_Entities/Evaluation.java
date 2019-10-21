package tn.esprit.Pidev_Entities;
import java.io.Serializable;
import java.util.Date;
import java.util.*;

import javax.persistence.*;

@Entity
public class Evaluation implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="Eval_ID")
	int id;
	@Column(name="Nom_Eval")
	private String Nom_Eval;
	@Column(name="desc_Eval")
	private String desc_Eval  ;
	@Column(name="score_self_Eval")
	private  Integer score_self ; 
	@Column(name="score_team_Eval")
	private Integer score_team ;
	@Column(name="score_Manager_Eval")
	private  Integer score_Manager ;
	@Enumerated(EnumType.STRING)
	@Column(name="Type_Eval")
	Type_Evaluation Type; 
	@Column(name="DATE_EVAL")
	@Temporal
	(TemporalType.TIMESTAMP)
	private Date DATE_EVAL ;
	
	
	//relation user evaluation
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_Eval_User",
	joinColumns={@JoinColumn(name="Eval_ID")},
	inverseJoinColumns={@JoinColumn(name ="UT_ID")})
	private Set<User> Users;
	
	public Evaluation() {}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_Eval() {
		return Nom_Eval;
	}
	public void setNom_Eval(String nom_Eval) {
		Nom_Eval = nom_Eval;
	}
	public String getDesc_Eval() {
		return desc_Eval;
	}
	public void setDesc_Eval(String desc_Eval) {
		this.desc_Eval = desc_Eval;
	}
	
	public Integer getScore_self() {
		return score_self;
	}


	public void setScore_self(Integer score_self) {
		this.score_self = score_self;
	}


	public Integer getScore_team() {
		return score_team;
	}


	public void setScore_team(Integer score_team) {
		this.score_team = score_team;
	}


	public Integer getScore_Manager() {
		return score_Manager;
	}


	public void setScore_Manager(Integer score_Manager) {
		this.score_Manager = score_Manager;
	}


	public Set<User> getUsers() {
		return Users;
	}


	public void setUsers(Set<User> users) {
		Users = users;
	}


	public Type_Evaluation getType() {
		return Type;
	}
	public void setType(Type_Evaluation type) {
		Type = type;
	}
	public Date getDATE_EVAL() {
		return DATE_EVAL;
	}
	public void setDATE_EVAL(Date dATE_EVAL) {
		DATE_EVAL = dATE_EVAL;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	











}
