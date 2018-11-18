package io.swagger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.IngredientList;
import io.swagger.model.CompleteRecipe;
import io.swagger.repository.IngredientListRepository;
import io.swagger.repository.IngredientRepository;
import io.swagger.repository.RecipeRepository;
@Service
public class IngredientListServiceImpl implements IngredientListService{

	@Autowired
	private RecipeRepository recipeRepository ;
	@Autowired
	private IngredientListRepository ingredientListRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
   
	
	
	@Override
	public CompleteRecipe getIngrednetList(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompleteRecipe createIngrednetList(IngredientList ingredientList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompleteRecipe updateIngrednetList(IngredientList ingredientList) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	@Override
	public CompleteRecipe createRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Override
	public CompleteRecipe updateRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}*/

}
