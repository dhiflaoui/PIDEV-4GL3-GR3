package tn.esprit.Pidev_Entities;
import java.io.Serializable;

import java.util.Date;
import java.util.*;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement

public class Evaluation implements Serializable {
	
	private static final long serialVersionUID = -1396669830860400871L;
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column
	int id;
	@Column
	private String Titre_Eval;
	@Column
	private String desc_Eval  ;
	@Column
	private  int score_self ; 
	@Column
	private int score_team ;
	@Column
	private  int score_Manager ;
	@Enumerated(EnumType.STRING)
	@Column
	Type_Evaluation Type; 
	@Column
	@Temporal
	(TemporalType.TIMESTAMP)
	private Date DATE_EVAL ;
	
	public Evaluation(int id ,String Titre_Eval, String desc_Eval, Type_Evaluation Type,int score_Manager) {
		super();
		this.id = id;
		this.desc_Eval = desc_Eval;
		this.Titre_Eval = Titre_Eval;
		this.Type = Type;
		this.score_Manager = score_Manager;
		
		
	}

	public Evaluation(String Titre_Eval, String desc_Eval, Type_Evaluation Type,Date DATE_EVAL,int score_Manager) {
		super();
		this.score_Manager = score_Manager;
		this.Titre_Eval = Titre_Eval;
		this.desc_Eval = desc_Eval;
		this.Type = Type;
		this.DATE_EVAL = DATE_EVAL;
		
	}
	
	public Evaluation(int score_self) {
		super();
		this.score_self = score_self;
		
	}
	
	
	public Evaluation() {
		super();
	}
	
	
	
	public Evaluation(String Titre_Eval, String desc_Eval, Type_Evaluation Type, Date DATE_EVAL) {
		super();
		this.Titre_Eval = Titre_Eval;
		this.desc_Eval = desc_Eval;
		this.Type = Type;
		this.DATE_EVAL = DATE_EVAL;
	}

	


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre_Eval() {
		return Titre_Eval;
	}



	public void setTitre_Eval(String titre_Eval) {
		Titre_Eval = titre_Eval;
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


	@ManyToOne
	private User user;


	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}



}
