package com.fitness.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fitness.entities.Diet;
import com.fitness.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DietDao {

	@Autowired
	private EntityManager entityManager;

	public List<Diet> findAllDiet() {

		TypedQuery<Diet> query = entityManager.createQuery("from Diet", Diet.class);
		List<Diet> diets = query.getResultList();
		return diets;

	}

	public Diet findById(int id) {
		Diet diet = entityManager.find(Diet.class, id);
		return diet;
	}

	@Transactional
	public String addDiet(Diet diet) {
		entityManager.merge(diet);
		return " Diet Added ";

	}

	@Transactional
	public String changeDiet(Diet diet) {
		Long i = diet.getDietId();
		Diet d = entityManager.find(Diet.class, i);
		if (d == null)
			return "No id found";
		d.setType(diet.getType());
		d.setCaloriesNeeded(diet.getCaloriesNeeded());
		d.setDescription(diet.getDescription());
		d.setU(diet.getU());
		entityManager.merge(d);
		return " Diet Changed ";
	}

	@Transactional
	public String deleteDiet(int id) {
		Diet diet = entityManager.find(Diet.class, id);
		if (diet == null)
			return "No id found";
		entityManager.remove(diet);
		return "A Diet Deleted ";
	}

}
