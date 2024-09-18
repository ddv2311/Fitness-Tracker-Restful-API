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
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	public List<User> findAllUser() {

		TypedQuery<User> query = entityManager.createQuery("from User", User.class);
		List<User> users = query.getResultList();
		return users;
	}

	public User findById(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	@Transactional
	public String addUser(User user) {
		entityManager.merge(user);
		return " User Added ";

	}

	@Transactional
	public String changeUser(User user) {
		Long i = user.getUserId();
		User u = entityManager.find(User.class, i);
		if (u == null)
			return "No id found";

		u.setAge(user.getAge());
		u.setHeight(user.getHeight());
		u.setPhoneNo(user.getPhoneNo());
		u.setUsername(user.getUsername());
		u.setWeight(user.getWeight());
		entityManager.merge(u);
		return " User Changed ";
	}

	@Transactional
	public String deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		TypedQuery<Diet> query = entityManager.createQuery("from Diet where u=:q", Diet.class);
		query.setParameter("q", user);
		List<Diet> diet = query.getResultList();
		for (int i = 0; i < diet.size(); i++) {
			entityManager.remove(diet.get(i));
		}
		TypedQuery<WorkOut> q = entityManager.createQuery("from WorkOut where u=:q", WorkOut.class);
		q.setParameter("q", user);
		List<WorkOut> workout = q.getResultList();
		for (int i = 0; i < workout.size(); i++) {
			entityManager.remove(workout.get(i));
		}
		entityManager.remove(user);
		return "A User is Deleted ";
	}

}
