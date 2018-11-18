package io.swagger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * CompleteRecipeList
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-17T22:44:18.369Z")

public class CompleteRecipeList   {
  @JsonProperty("recipeList")
  @Valid
  private List<CompleteRecipe> recipeList = null;

  public CompleteRecipeList recipeList(List<CompleteRecipe> recipeList) {
    this.recipeList = recipeList;
    return this;
  }

  public CompleteRecipeList addRecipeListItem(CompleteRecipe recipeListItem) {
    if (this.recipeList == null) {
      this.recipeList = new ArrayList<CompleteRecipe>();
    }
    this.recipeList.add(recipeListItem);
    return this;
  }

  /**
   * Get recipeList
   * @return recipeList
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CompleteRecipe> getRecipeList() {
    return recipeList;
  }

  public void setRecipeList(List<CompleteRecipe> recipeList) {
    this.recipeList = recipeList;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CompleteRecipeList CompleteRecipeList = (CompleteRecipeList) o;
    return Objects.equals(this.recipeList, CompleteRecipeList.recipeList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(recipeList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CompleteRecipeList {\n");
    
    sb.append("    recipeList: ").append(toIndentedString(recipeList)).append("\n");
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

