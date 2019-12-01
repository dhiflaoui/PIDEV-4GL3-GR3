package managedbeans;


import java.io.Serializable;


import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.*;

import tn.esprit.PidevService.Impl.EmployeService;
import tn.esprit.PidevService.Impl.EvaluationService;
import  tn.esprit.Pidev_Entities.*;



@ManagedBean(name = "EvaluationBean") 
@SessionScoped
public class EvaluationBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String titre_eval;
	private String desc_eval;  
	private Date DATE_EVAL;
	private  int  score_self;
	private  int Score_Manager;
	private int val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11,val12,val13,val14,val15,val16;
	private int E2,E1;
	private int var1;
	private  int score_team;
	private int selectUserById;
	
	private Type_Evaluation type_eval;
	private List<Evaluation> evaluations;
	//private List<Integer>scorelist;
	private Boolean ToBeEval;

	private Integer EvaluationIdToBeUpdated;

	
	






	
/*******************************************************************************/


public Integer getEvaluationIdToBeUpdated() {
	return EvaluationIdToBeUpdated;
}


public void setEvaluationIdToBeUpdated(Integer EvaluationIdToBeUpdated) {
	this.EvaluationIdToBeUpdated = EvaluationIdToBeUpdated;
}
	
	@EJB
	EvaluationService evaluationService;
	@EJB
	EmployeService userservice;
	
	
	

	public int getVal14() {
		return val14;
	}

	public void setVal14(int val14) {
		this.val14 = val14;
	}

	public int getVal15() {
		return val15;
	}

	public void setVal15(int val15) {
		this.val15 = val15;
	}

	public int getVal16() {
		return val16;
	}

	public void setVal16(int val16) {
		this.val16 = val16;
	}

	public int getVal1() {
		return val1;
	}

	public void setVal1(int val1) {
		this.val1 = val1;
	}

	public int getVal12() {
		return val12;
	}

	public void setVal12(int val12) {
		this.val12 = val12;
	}


	public int getVal2() {
		return val2;
	}

	public void setVal2(int val2) {
		this.val2 = val2;
	}

	public int getVal3() {
		return val3;
	}

	public void setVal3(int val3) {
		this.val3 = val3;
	}

	public int getVal4() {
		return val4;
	}

	public void setVal4(int val4) {
		this.val4 = val4;
	}

	public int getVal5() {
		return val5;
	}

	public void setVal5(int val5) {
		this.val5 = val5;
	}

	public int getVal6() {
		return val6;
	}

	public void setVal6(int val6) {
		this.val6 = val6;
	}

	public int getVal7() {
		return val7;
	}

	public void setVal7(int val7) {
		this.val7 = val7;
	}

	public int getVal8() {
		return val8;
	}

	public void setVal8(int val8) {
		this.val8 = val8;
	}

	public int getVal9() {
		return val9;
	}

	public void setVal9(int val9) {
		this.val9 = val9;
	}

	public int getVal10() {
		return val10;
	}

	public void setVal10(int val10) {
		this.val10 = val10;
	}

	public int getVal11() {
		return val11;
	}

	public void setVal11(int val11) {
		this.val11 = val11;
	}

	public int getScore_team() {
		return score_team;
	}


	public void setScore_team(int score_team) {
		this.score_team = score_team;
	}


	
	
	public int getScore_Manager() {
		return Score_Manager;
	}


	public void setScore_Manager(int score_Manager) {
		Score_Manager = score_Manager;
	}


	public String getTitre_eval() {
		return titre_eval;
	}

	public void setTitre_eval(String titre_eval) {
		this.titre_eval = titre_eval;
	}

	public String getDesc_eval() {
		return desc_eval;
	}

	public void setDesc_eval(String desc_eval) {
		this.desc_eval = desc_eval;
	}

	public Type_Evaluation getType_eval() {
		return type_eval;
	}

	public void setType_eval(Type_Evaluation type_eval) {
		this.type_eval = type_eval;
	}
	
	public int getScore_self() {
		return score_self;
	}


	public void setScore_self(int score_self) {
		this.score_self = score_self;
	}


	

	public int getVal13() {
		return val13;
	}

	public void setVal13(int val13) {
		this.val13 = val13;
	}


	


	public int getVar1() {
		return var1;
	}


	public void setVar1(int var1) {
		this.var1 = var1;
	}
	
	
	public int getE2() {
		return E2;
	}


	public void setE2(int e2) {
		E2 = e2;
	}


	public int getE1() {
		return E1;
	}


	public void setE1(int e1) {
		E1 = e1;
	}


	
	
	
	
	
	
	
	
	
	
	
	


	public List<Evaluation> getEvaluations() {
		evaluations = evaluationService.getAllEvaluations();
		return evaluations;
	}

	public int getSelectUserById() {
		return selectUserById;
	}

	public void setSelectUserById(int selectUserById) {
		this.selectUserById = selectUserById;
	}

	
	

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}
	public Boolean getToBeEval() {
		return ToBeEval;
	}

	public void setToBeEval(Boolean toBeEval) {
		ToBeEval = toBeEval;
	}

/******************************************function******************************************************/
	
	private List<User> users;
	public List<User> getUsers(){
		users = userservice.getAllUser(); 
		return users;
	}
	 
	
//evaluation ajouter par le manager
	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addEvaluationM() {
	
		 type_eval=Type_Evaluation.program_Eval;
		 Date date = new Date(); 
		 DATE_EVAL = date;
		 User userSelected = userservice.getUserById(selectUserById);
		 Evaluation Eval = new Evaluation(titre_eval, desc_eval,type_eval,DATE_EVAL,Score_Manager);
		 Eval.setUser(userSelected);
		 evaluationService.ajouterEvaluation(Eval);
		 System.out.println("leeeeeeeeeeeeeeeee"+selectUserById+"leeeeeeeeeeeeeeeee"+""+userSelected.getNom());
		}  

	
	
	//evaluation employe
	
		public void addEvaluationE() {
			 type_eval=Type_Evaluation.Self_Eval;
			 Date date = new Date();
			 DATE_EVAL = date ;
			 User userSelected = userservice.getUserById(selectUserById);
			 Evaluation Eval = new Evaluation(titre_eval, desc_eval,type_eval,DATE_EVAL,score_self);
			 Eval.setUser(userSelected);
			 evaluationService.ajouterEvaluation(Eval);
			}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void addEvaluationTM() {
		Date date = new Date();
		 DATE_EVAL = date ;
		 type_eval=Type_Evaluation.Team_Eval;
		// ToBeEval=true;
		 User userSelected=userservice.getUserById(selectUserById);
		 System.out.println(userSelected);
		 userSelected.setToBeEval(true);
		 userservice.updateUser(userSelected);
		 Evaluation Eval =new Evaluation(titre_eval, desc_eval,type_eval,DATE_EVAL);
		 Eval.setUser(userSelected);
		 evaluationService.ajouterEvaluation(Eval);
	
		}
	
	
	
	
	//score team eval
	
	
		public void add_scoreTeamEval() {
		
				 type_eval=Type_Evaluation.Team_Eval;
				 Date date = new Date(); 
				 DATE_EVAL = date;
				 User userSelected=userservice.getUserById(selectUserById);
				 userSelected.setToBeEval(false);
				 userservice.updateUser(userSelected);
				 Evaluation Eval = new Evaluation(titre_eval, desc_eval,type_eval,DATE_EVAL,score_team);
				 Eval.setUser(userSelected);
				 evaluationService.ajouterEvaluation(Eval);
				 	
				}  
	
		

		
		
		
	
	
	
	
	 
	/*
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Integer> getScorelist() {
		return scorelist;
	}

	public void setScorelist(List<Integer> scorelist) {
		this.scorelist = scorelist;
	}
	 
	public void addselfscore() {
		 type_eval=Type_Evaluation.Self_Eval;
		 Date date = new Date();
		 DATE_EVAL = date ;
		 titre_eval="self";
		 desc_eval="selfsccore";
		 scorelist=new ArrayList<Integer>();
		 scorelist.add(score);
		int count=0;
		
		 for(int i=0 ;i < scorelist.size() ; i++)
		 {
			 count+=scorelist.get(i);
		 }
		
		 count=scorelist.get(score);
		score_self=count;	 
		evaluationService.ajouterEvaluation(new Evaluation(titre_eval, desc_eval,type_eval,DATE_EVAL,score_self));
		System.out.println("le score est"+count);
		System.out.println("ajout fait" + score_self );
		}*/
	
	

	
	//modification*********************************************************************************
	public void removeEvaluation(int Eval_id)
	{
	evaluationService.deleteEvaluationById(Eval_id); 
	}


	public void modifierEval(Evaluation evaluation)
	{this.setTitre_eval(evaluation.getTitre_Eval());;
	this.setDesc_eval(evaluation.getDesc_Eval());
	this.setType_eval(evaluation.getType());
	this.setScore_Manager(evaluation.getScore_Manager());
	this.setEvaluationIdToBeUpdated(evaluation.getId());
	}
		
	public void mettreAjourEvaluation(){
		evaluationService.updateEvaluation(new Evaluation(EvaluationIdToBeUpdated,titre_eval, desc_eval,type_eval,Score_Manager)); 
	}


	


	
	
	
	
}
