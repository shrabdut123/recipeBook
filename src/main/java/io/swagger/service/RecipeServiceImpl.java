package io.swagger.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.model.CompleteRecipe;
import io.swagger.model.CompleteRecipeList;
import io.swagger.model.Ingredient;
import io.swagger.model.IngredientList;
import io.swagger.model.Recipe;
import io.swagger.model.RecipeIngredient;
import io.swagger.repository.IngredientListRepository;
import io.swagger.repository.IngredientRepository;
import io.swagger.repository.RecipeRepository;
import io.swagger.search.Search;
@Service
public class RecipeServiceImpl implements RecipeService{

	@Autowired
	private RecipeRepository recipeRepository ;
	@Autowired
	private IngredientListRepository ingredientListRepository;
	@Autowired
	private IngredientRepository ingredientRepository;
	 @Autowired
    private Search recipeSearch;
	
	
	@Override
	public CompleteRecipe getRecipe(Integer p, Integer recipeId) {
		CompleteRecipe completeRecipe = new CompleteRecipe();
		Recipe recipe = recipeRepository.getOne(recipeId);
		List<IngredientList> ingredientsList = ingredientListRepository.findByRecipeId(recipe);
		List<RecipeIngredient> recipeIngredients = null;
		completeRecipe.setId(recipeId);
		completeRecipe.setName(recipe.getName());
		if(null == p) {
			completeRecipe.setPeople(recipe.getPeople());
			recipeIngredients = ingredientsList.
					stream().
					map((IngredientList im) -> new RecipeIngredient(im.getIngredient().getId(),im.getIngredient().getName(), im.getAmount())
					).collect(Collectors.toList());
			
		}else {
			completeRecipe.setPeople(p);
			int initialServing = recipe.getPeople();
			int factor = p%initialServing == 0 ?  p%initialServing :p%initialServing + 1 ;
			recipeIngredients = ingredientsList.
					stream().
					map((IngredientList im) -> new RecipeIngredient(im.getIngredient().getId(),im.getIngredient().getName(), im.getAmount()*factor)
					).collect(Collectors.toList());
		}
		completeRecipe.setIngredients(recipeIngredients);
		return completeRecipe;
	}
	
	
	@Override
	public CompleteRecipeList getAllRecipes(String q) {
		
		CompleteRecipeList completeRecipeList = new CompleteRecipeList();
		if(null != q) {
			List<Recipe> recipes = recipeSearch.searchRecipe(q);
			for (Recipe Recipe : recipes) {
				CompleteRecipe completeRecipe = new CompleteRecipe();
				completeRecipe.setId(Recipe.getId());
				completeRecipe.setName(Recipe.getName());
				completeRecipe.setPeople(Recipe.getPeople());
				List<IngredientList> ingredientsList = ingredientListRepository.findByRecipeId(Recipe);
				List<RecipeIngredient> ingredients = ingredientsList.
						stream().
						map((IngredientList im) ->  new RecipeIngredient(im.getIngredient().getId(),im.getIngredient().getName(), im.getAmount())
						).collect(Collectors.toList());
				completeRecipe.setIngredients(ingredients);
				completeRecipeList.addRecipeListItem(completeRecipe);
			}
		}
		return completeRecipeList;
	}

	@Override
	public CompleteRecipe createRecipe(CompleteRecipe completeRecipe) {
		Recipe Recipe = new Recipe();
		Recipe.setName(completeRecipe.getName());
		Recipe.setPeople(completeRecipe.getPeople());
		Recipe recipeDB = recipeRepository.save(Recipe);
		List<RecipeIngredient> recipeIngredients = completeRecipe.getRecipeIngredients();
		for (RecipeIngredient recipeIngredient : recipeIngredients) {
			IngredientList ingredientList = new IngredientList();
			ingredientList.setAmount(recipeIngredient.getAmount());
			Ingredient ingredient = ingredientRepository.findOne(recipeIngredient.getId());
			ingredientList.setIngredient(ingredient);
			ingredientList.setRecipeEntity(recipeDB);
			
			ingredientListRepository.save(ingredientList);
		}
		
		
		return getRecipe(null, recipeDB.getId());
	}

	@Override
	public CompleteRecipe updateRecipe(Integer recipeId, CompleteRecipe completeRecipe) {
		Recipe recipe = recipeRepository.getOne(recipeId);
		recipe.setName(completeRecipe.getName());
		recipe.setPeople(completeRecipe.getPeople());
		Recipe recipeDB = recipeRepository.save(recipe);
		
		return getRecipe(null, recipeDB.getId());
	}

	

}
