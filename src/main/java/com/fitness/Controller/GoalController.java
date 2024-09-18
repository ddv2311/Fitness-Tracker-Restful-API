package com.fitness.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.Service.GoalService;
import com.fitness.Service.UserService;
import com.fitness.entities.Goal;
import com.fitness.entities.User;

@RestController
@RequestMapping("/goal")
public class GoalController {
	@Autowired
	private GoalService service;
	
	
	//1. Read All or Single goal...
	
	@GetMapping("/find")
	public List<Goal> findallGoal()
	{
		return this.service.findAllGoal();
	}
	@GetMapping("/find/{id}")
	public Goal findById(@PathVariable int id)
	{
		return this.service.findById(id);
	}
	
	//2. add A Goal...
	
	@PostMapping("/addGoal")
	public String addGoal(@RequestBody Goal goal)
	{
		return this.service.addGoal(goal);
	}
		
	//3. change Goal by Id...
		
	@PutMapping("/changeGoal")
	public String changeGoal(@RequestBody Goal goal)
	{
		return this.service.changeGoal(goal);
	}

	//4. Delete Goal by Id...
	
	@DeleteMapping("/deleteGoal/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return service.deleteGoal(id);
	}

}