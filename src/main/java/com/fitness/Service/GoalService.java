package com.fitness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Dao.DietDao;
import com.fitness.Dao.GoalDao;
import com.fitness.entities.Diet;
import com.fitness.entities.Goal;

@Service
public class GoalService {

	@Autowired
	private GoalDao dao;

	public List<Goal> findAllGoal() {
		return dao.findAllGoal();
	}

	public Goal findById(int id) {
		return dao.findById(id);
	}

	public String addGoal(Goal goal) {
		return this.dao.addGoal(goal);
	}

	public String changeGoal(Goal goal) {
		return this.dao.changeGoal(goal);
	}

	public String deleteGoal(int id) {
		return this.dao.deleteGoal(id);
	}

}