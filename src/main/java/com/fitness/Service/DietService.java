package com.fitness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Dao.DietDao;
import com.fitness.Dao.UserDao;
import com.fitness.entities.Diet;
import com.fitness.entities.User;

@Service
public class DietService {

	@Autowired
	private DietDao dao;
	
	public List<Diet> findAllDiet() {
		return dao.findAllDiet();
	}
	public Diet findById(int id)
	{
		return dao.findById(id);
	}
	
	
	public String addDiet(Diet diet)
	{
		return this.dao.addDiet(diet);
	}
	
	
	public String changeDiet(Diet diet) 
	{
		return this.dao.changeDiet(diet);
	}
	
	
	 public String deleteDiet(int id)
	 {
		 return this.dao.deleteDiet(id);
	 }
	 
	 

}
