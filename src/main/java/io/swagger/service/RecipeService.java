package io.swagger.service;


import io.swagger.model.CompleteRecipe;
import io.swagger.model.CompleteRecipeList;

public interface RecipeService {
	
	CompleteRecipe getRecipe(Integer p ,Integer id);
	CompleteRecipe createRecipe(CompleteRecipe CompleteRecipe);
	CompleteRecipeList getAllRecipes(String q);
	CompleteRecipe updateRecipe(Integer recipeId, CompleteRecipe completeRecipe);

}

