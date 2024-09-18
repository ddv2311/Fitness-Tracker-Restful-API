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

import com.fitness.Service.UserService;
import com.fitness.Service.WorkOutService;
import com.fitness.entities.Diet;
import com.fitness.entities.User;
import com.fitness.entities.WorkOut;

@RestController
@RequestMapping("/workout")
public class WorkOutController {

	@Autowired
	private WorkOutService service;
	
	
	//1. Read All or Single WorkOut...
	
	@GetMapping("/find")
	public List<WorkOut> findallUser()
	{
		return this.service.findAllWorkout();
	}
	@GetMapping("/find/{id}")
	public WorkOut findById(@PathVariable int id)
	{
		return this.service.findById(id);
	}
	
	//2. add A diet...
	
	@PostMapping("/addWorkout")
	public String addWorkout(@RequestBody WorkOut workout)
	{
		return this.service.addWorkout(workout);
	}
	
	//3. change WorkOut by Id...
	
	@PutMapping("/changeWorkout")
	public String changeDiet(@RequestBody WorkOut workout)
	{
		return this.service.changeWorkout(workout);
	}
	

	//4. Delete WorkOut by Id...
	
	@DeleteMapping("/deleteWorkout/{id}")
	public String deleteDiet(@PathVariable int id)
	{
		return service.deleteWorkout(id);
	}
}
