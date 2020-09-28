package com.nathanrajkumar.main.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import com.nathanrajkumar.main.domain.Recipe;
import com.nathanrajkumar.main.repository.RecipeRepository;

@Service
public class RecipeService {
	

	@Autowired
	private RecipeRepository recipeRepo;	
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void initRecipes() throws IOException {
		recipeRepo.saveRecipeList(getAllRecipes());
	}
	
	public List<Recipe> getAllRecipes() throws IOException {
		List<Recipe> recipes = new ArrayList<>();
		Reader in = new FileReader("recipes.txt");
		 for (CSVRecord record : CSVFormat.DEFAULT.withIgnoreSurroundingSpaces().withFirstRecordAsHeader().withEscape('\\').parse(in)) {
			 Recipe recipe = new Recipe(Integer.parseInt(record.get(0)), Boolean.parseBoolean(record.get(1)), Boolean.parseBoolean(record.get(2)), record.get(3), Double.parseDouble(record.get(4)), Double.parseDouble(record.get(5)), Integer.parseInt(record.get(6)), Integer.parseInt(record.get(7)), Double.parseDouble(record.get(8)), record.get(9), Boolean.parseBoolean(record.get(10)), Boolean.parseBoolean(record.get(11)));
			 recipes.add(recipe);
		 }
		 return recipes;
	}
}
