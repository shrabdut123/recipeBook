package io.swagger.service;

import java.util.List;

import io.swagger.model.Ingredient;

public interface IngredientService {
	
	Ingredient getIngredient(Integer id);
	Ingredient createIngredient(Ingredient ingredient);
	Ingredient updateIngredient(Ingredient ing);
	List<Ingredient> getAllIngredients();
	

}
