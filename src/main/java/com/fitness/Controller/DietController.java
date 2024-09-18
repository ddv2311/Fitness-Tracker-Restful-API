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

import com.fitness.Service.DietService;
import com.fitness.Service.UserService;
import com.fitness.entities.Diet;
import com.fitness.entities.User;

@RestController
@RequestMapping("/diet")
public class DietController {
	
	@Autowired
	private DietService service;
	
	
	//1. Read All or Single diet...
	
	@GetMapping("/find")
	public List<Diet> findAllDiet()
	{
		return this.service.findAllDiet();
	}
	@GetMapping("/find/{id}")
	public Diet findById(@PathVariable int id)
	{
		return this.service.findById(id);
	}
	
	//2. add A diet...
	
	@PostMapping("/addDiet")
	public String addDiet(@RequestBody Diet diet)
	{
		return this.service.addDiet(diet);
	}
	
	//3. change diet by Id...
	
	@PutMapping("/changeDiet")
	public String changeDiet(@RequestBody Diet diet)
	{
		return this.service.changeDiet(diet);
	}
	
	//4. Delete diet by Id...
	
	@DeleteMapping("/deleteDiet/{id}")
	public String deleteDiet(@PathVariable int id)
	{
		return service.deleteDiet(id);
	}
	
	

}
