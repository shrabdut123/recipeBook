package io.swagger.service;


import io.swagger.model.IngredientList;
import io.swagger.model.CompleteRecipe;

public interface IngredientListService {
	
	CompleteRecipe getIngrednetList(Integer id);
	CompleteRecipe createIngrednetList(IngredientList ingredientList);
	CompleteRecipe updateIngrednetList(IngredientList ingredientList);
	

}

