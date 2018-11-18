package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.swagger.model.IngredientList;
import io.swagger.model.Recipe;
@Repository
public interface IngredientListRepository  extends JpaRepository<IngredientList, Integer>{

	
	 @Query("SELECT i FROM IngredientList i WHERE i.recipe=?1")
	 public List<IngredientList> findByRecipeId(@Param("recipe") Recipe recipeEntity);
}
