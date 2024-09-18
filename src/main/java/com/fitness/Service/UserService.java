package com.fitness.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitness.Dao.UserDao;
import com.fitness.entities.Diet;
import com.fitness.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;
	
	public List<User> findAllUser()
	{
		return dao.findAllUser();
	}
	public User findById(int id)
	{
		return dao.findById(id);
	}
	
	public String addUser(User user)
	{
		return this.dao.addUser(user);
	}
	
	public String changeUser(User user) 
	{
		return this.dao.changeUser(user);
	}
	
	public String deleteUser(int id)
	 {
		 return this.dao.deleteUser(id);
	 }
}
