package io.swagger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="INGREDIENT_LIST")
public class IngredientList {

	

	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private int id;
	
	@OneToOne( targetEntity=Recipe.class )
	private Recipe recipe;
	
	@OneToOne( targetEntity=Ingredient.class )
	private Ingredient ingredient;
	
	@NotNull
	private int amount;

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Recipe getRecipeEntity() {
		return recipe;
	}

	public void setRecipeEntity(Recipe Recipe) {
		this.recipe = Recipe;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
}
