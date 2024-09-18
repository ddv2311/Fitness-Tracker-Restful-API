package com.fitness.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkOut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workoutId;

	private String type;

	private int durationInMinutes;

	private double caloriesBurned;
	
	@ManyToOne
	
	private User u;

	public Long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(Long workoutId) {
		this.workoutId = workoutId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public double getCaloriesBurned() {
		return caloriesBurned;
	}

	public void setCaloriesBurned(double caloriesBurned) {
		this.caloriesBurned = caloriesBurned;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@Override
	public String toString() {
		return "WorkOut [workoutId=" + workoutId + ", type=" + type + ", durationInMinutes=" + durationInMinutes
				+ ", caloriesBurned=" + caloriesBurned + ", u=" + u + "]";
	}

	
}
