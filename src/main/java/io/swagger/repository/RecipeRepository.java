package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Recipe;
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
/*
	 @Query("SELECT B.ID,B.NAME,B.PEOPLE,A.AMOUNT, C.ID,C.NAME AS INGREDIENTNAME FROM INGREDIENT_LIST A, RECIPE B, INGREDIENT C WHERE A.RECIPE_ID=:recipeId and B.ID=:recipeId and A.INGREDIENT_ID=C.ID")
	    public List<RecipeIngredient> findRecipe(@Param("recipeId") Integer recipeId);*/
}