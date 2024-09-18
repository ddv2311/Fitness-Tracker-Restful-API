package com.fitness.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.entities.Diet;
import com.fitness.entities.User;
import com.fitness.entities.WorkOut;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class WorkOutDao {

	@Autowired
	private EntityManager entityManager;
	
	public List<WorkOut> findAllWorkout() {
		
		TypedQuery<WorkOut> query=entityManager.createQuery("from WorkOut",WorkOut.class);
		List<WorkOut> workOuts = query.getResultList();
		return workOuts;
		
	}

	public WorkOut findById(int id) {
		WorkOut workOut=entityManager.find(WorkOut.class,id);
		return workOut;
	}

	@Transactional
	public String addWorkout(WorkOut workout)
	{
		entityManager.merge(workout);
		return " WorkOut Added ";
		
	}
	
	@Transactional
	public String changeWorkout(WorkOut workout) {
		Long i = workout.getWorkoutId();
		WorkOut w = entityManager.find(WorkOut.class,i);
		if(w == null)
			return "No id found";
		
		w.setCaloriesBurned(workout.getCaloriesBurned());
		w.setDurationInMinutes(workout.getDurationInMinutes());
		w.setType(workout.getType());
		w.setU(workout.getU());
		
		entityManager.merge(w);
		return " Workout Changed ";
	}
	
	@Transactional
    public String deleteWorkout(int id)
    {
   	 WorkOut w=entityManager.find(WorkOut.class,id);
   	if(w == null)
		return "No id found";
   	 entityManager.remove(w);
   	 return "A Workout Deleted ";
    }
}
