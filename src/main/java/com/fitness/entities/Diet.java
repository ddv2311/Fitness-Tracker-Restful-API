package com.fitness.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Diet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dietId;

	private String type;

	private String description;

	private int caloriesNeeded;

	@OneToOne
	private User u;

	public Long getDietId() {
		return dietId;
	}

	public void setDietId(Long dietId) {
		this.dietId = dietId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCaloriesNeeded() {
		return caloriesNeeded;
	}

	public void setCaloriesNeeded(int caloriesNeeded) {
		this.caloriesNeeded = caloriesNeeded;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String toString() {
		return "Diet [dietId=" + dietId + ", type=" + type + ", description=" + description + ", caloriesNeeded="
				+ caloriesNeeded + ", u=" + u + "]";
	}

}
