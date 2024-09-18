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
import com.fitness.entities.Diet;
import com.fitness.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService service;
	
	
	//1. Read All or Single user...
	
	@GetMapping("/find")
	public List<User> findallUser()
	{
		return this.service.findAllUser();
	}
	@GetMapping("/find/{id}")
	public User findById(@PathVariable int id)
	{
		return this.service.findById(id);
	}
	
	//2. add A diet...
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user)
	{
		return this.service.addUser(user);
	}
		
	//3. change User by Id...
		
	@PutMapping("/changeUser")
	public String changeUser(@RequestBody User user)
	{
		return this.service.changeUser(user);
	}

	//4. Delete diet by Id...
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id)
	{
		return service.deleteUser(id);
	}
	
	
}
