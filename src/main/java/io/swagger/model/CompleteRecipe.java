package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CompleteRecipe
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-17T22:44:18.369Z")

public class CompleteRecipe   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("people")
  private Integer people = null;

  @JsonProperty("recipeIngredients")
  @Valid
  private List<RecipeIngredient> recipeIngredients = null;

  

  public CompleteRecipe id(Integer id) {
    this.id = id;
    return this;
  }
  public CompleteRecipe() {
	  
  }

  public CompleteRecipe(Integer id, String name, Integer people, List<RecipeIngredient> recipeIngredients  ) {
	  this.id = id;
	  this.name = name;
	  this.people = people;
	  this.recipeIngredients = recipeIngredients;
  }
  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CompleteRecipe name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Recipe_1", value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CompleteRecipe people(Integer people) {
    this.people = people;
    return this;
  }

  /**
   * Get people
   * @return people
  **/
  @ApiModelProperty(example = "4", value = "")


  public Integer getPeople() {
    return people;
  }

  public void setPeople(Integer people) {
    this.people = people;
  }

  public CompleteRecipe recipeIngredients(List<RecipeIngredient> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
    return this;
  }

  public CompleteRecipe addrecipeIngredientsItem(RecipeIngredient recipeIngredientsItem) {
    if (this.recipeIngredients == null) {
      this.recipeIngredients = new ArrayList<RecipeIngredient>();
    }
    this.recipeIngredients.add(recipeIngredientsItem);
    return this;
  }

  /**
   * Get ingredients
   * @return ingredients
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RecipeIngredient> getRecipeIngredients() {
    return recipeIngredients;
  }

  public void setIngredients(List<RecipeIngredient> recipeIngredients) {
    this.recipeIngredients = recipeIngredients;
  }

 

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteRecipe CompleteRecipe = (CompleteRecipe) o;
    return Objects.equals(this.id, CompleteRecipe.id) &&
        Objects.equals(this.name, CompleteRecipe.name) &&
        Objects.equals(this.people, CompleteRecipe.people) &&
        Objects.equals(this.recipeIngredients, CompleteRecipe.recipeIngredients);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, people, recipeIngredients);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteRecipe {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    people: ").append(toIndentedString(people)).append("\n");
    sb.append("    recipeIngredients: ").append(toIndentedString(recipeIngredients)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

