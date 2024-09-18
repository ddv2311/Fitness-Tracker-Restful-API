package com.fitness.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Goal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long goalId;
	private String goalType;
	private int target_period;
	
	@OneToOne
	private User u;
	
	
	public Goal() {
		
	}

	

	public User getU() {
		return u;
	}



	public void setU(User u) {
		this.u = u;
	}



	public Goal(Long goalId, String goalType, int target_period, User u) {
		super();
		this.goalId = goalId;
		this.goalType = goalType;
		this.target_period = target_period;
		this.u = u;
	}


	public Long getGoalId() {
		return goalId;
	}
	public void setGoalId(Long goalId) {
		this.goalId = goalId;
	}
	public String getGoalType() {
		return goalType;
	}
	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}
	public int getTarget_period() {
		return target_period;
	}
	public void setTarget_period(int target_period) {
		this.target_period = target_period;
	}
	
	
	
}