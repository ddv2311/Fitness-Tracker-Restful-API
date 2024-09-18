package com.fitness.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.entities.Goal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class GoalDao {

	@Autowired
	private EntityManager entityManager;

	public List<Goal> findAllGoal() {

		TypedQuery<Goal> query = entityManager.createQuery("from Goal", Goal.class);
		List<Goal> goals = query.getResultList();
		return goals;

	}

	public Goal findById(int id) {
		Goal goal = entityManager.find(Goal.class, id);
		return goal;
	}

	@Transactional
	public String addGoal(Goal goal) {
		entityManager.merge(goal);
		return " Goal Added ";

	}

	@Transactional
	public String changeGoal(Goal goal) {
		Long i = goal.getGoalId();
		Goal g = entityManager.find(Goal.class, i);
		if (g == null)
			return "No id found";
		g.setGoalId(goal.getGoalId());
		g.setGoalType(goal.getGoalType());
		g.setTarget_period(goal.getTarget_period());
		entityManager.merge(g);
		return " Goal Changed ";
	}

	@Transactional
	public String deleteGoal(int id) {
		Goal goal = entityManager.find(Goal.class, id);
		if (goal == null)
			return "No id found";
		entityManager.remove(goal);
		return "A goal Deleted ";
	}
}