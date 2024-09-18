package com.fitness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Dao.WorkOutDao;
import com.fitness.entities.Diet;
import com.fitness.entities.User;
import com.fitness.entities.WorkOut;

@Service
public class WorkOutService {
	@Autowired
	private WorkOutDao dao;
	
	public List<WorkOut> findAllWorkout()
	{
		return dao.findAllWorkout();
	}
	public WorkOut findById(int id)
	{
		return dao.findById(id);
	}
	
	
	public String addWorkout(WorkOut workout)
	{
		return this.dao.addWorkout(workout);
	}
	
	
	public String changeWorkout(WorkOut workout) 
	{
		return this.dao.changeWorkout(workout);
	}
	
	public String deleteWorkout(int id)
	 {
		 return this.dao.deleteWorkout(id);
	 }
	
}
