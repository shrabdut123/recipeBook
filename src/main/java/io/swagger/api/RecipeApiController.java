package io.swagger.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.CompleteRecipe;
import io.swagger.model.CompleteRecipeList;
import io.swagger.model.RecipeNotFoundException;
import io.swagger.service.RecipeService;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-17T22:44:18.369Z")

@Controller
public class RecipeApiController implements RecipeApi {

    private static final Logger log = LoggerFactory.getLogger(RecipeApiController.class);

    private final HttpServletRequest request;
    
    @Autowired
    RecipeService recipeService;

    @org.springframework.beans.factory.annotation.Autowired
    public RecipeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<CompleteRecipe> addRecipe(@ApiParam(value = "" ,required=true )  @Valid @RequestBody CompleteRecipe completeRecipe) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	log.info("Inside Method addRecipe");
        	CompleteRecipe completeRecipeDB = recipeService.createRecipe(completeRecipe);
            return new ResponseEntity<CompleteRecipe>(completeRecipeDB, HttpStatus.OK);
        }

        return new ResponseEntity<CompleteRecipe>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CompleteRecipe> getRecipe(@ApiParam(value = "Number of people.") @Valid @RequestParam(value = "p", required = false) Integer p, @ApiParam(value = "The recipe ID.",required=true) @PathVariable("recipe_id") Integer recipeId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
           	log.info("Inside Method addRecipe, recipeId is:"+recipeId);
           CompleteRecipe completeRecipe = recipeService.getRecipe(p, recipeId);
           if(null== completeRecipe) {
              	throw new RecipeNotFoundException(recipeId + "-id: Not Found");
              }     
           return new ResponseEntity<CompleteRecipe>(completeRecipe, HttpStatus.OK);     
          
        }

        return new ResponseEntity<CompleteRecipe>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CompleteRecipeList> getRecipeByName(@ApiParam(value = "search keyword.") @Valid @RequestParam(value = "q", required = false) String q) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	CompleteRecipeList completeRecipeList = recipeService.getAllRecipes(q);
            return new ResponseEntity<CompleteRecipeList>(completeRecipeList, HttpStatus.OK);
        }

        return new ResponseEntity<CompleteRecipeList>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CompleteRecipe> updateRecipe(@ApiParam(value = "The recipe ID.",required=true) @PathVariable("recipe_id") Integer recipeId,@ApiParam(value = ""  )  @Valid @RequestBody CompleteRecipe completeRecipe) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	CompleteRecipe completeRecipeDB = recipeService.updateRecipe(recipeId, completeRecipe);
            return new ResponseEntity<CompleteRecipe>(completeRecipeDB, HttpStatus.OK);
        }

        return new ResponseEntity<CompleteRecipe>(HttpStatus.NOT_IMPLEMENTED);
    }

}
