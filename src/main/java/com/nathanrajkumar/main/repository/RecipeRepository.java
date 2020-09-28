package com.nathanrajkumar.main.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nathanrajkumar.main.domain.Recipe;

@Repository
public class RecipeRepository {

	public List<Recipe> recipes;
	
	public List<Recipe> saveRecipeList(List<Recipe> recipes) {
		return this.recipes = recipes;
	}
	
	public List<Recipe> getRecipeList() {
		return recipes;
	}
}
