package com.nathanrajkumar.main.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathanrajkumar.main.domain.Recipe;
import com.nathanrajkumar.main.repository.RecipeRepository;

@RestController
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepo;
	
	@GetMapping("/all-recipes")
	public List<Recipe> getAllRecipes() {
		return recipeRepo.getRecipeList();
	}
	
	@GetMapping("/gluten-free")
	public List<Recipe> getGlutenFreeRecipes() {
		return recipeRepo.getRecipeList().stream().filter(rec -> rec.getGlutenFree().equals(true)).collect(Collectors.toList());
	}
	
	@GetMapping("/vegan")
	public List<Recipe> getVeganRecipes() {
		return recipeRepo.getRecipeList().stream().filter(rec -> rec.getVegan().equals(true)).collect(Collectors.toList());
	}
	
	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> getVeganAndGlutenFreeRecipes() {
		return recipeRepo.getRecipeList().stream().filter(rec -> rec.getVegan().equals(true) && rec.getGlutenFree().equals(true)).collect(Collectors.toList());
	}
	
	@GetMapping("/vegetarian")
	public List<Recipe> getVegetarian() {
		return recipeRepo.getRecipeList().stream().filter(rec -> rec.getVegetarian().equals(true)).collect(Collectors.toList());
	}
}
