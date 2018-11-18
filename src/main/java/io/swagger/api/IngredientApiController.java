package io.swagger.api;

import java.util.List;

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
import io.swagger.model.Ingredient;
import io.swagger.model.IngredientListResponse;
import io.swagger.model.IngredientNotFoundException;
import io.swagger.search.Search;
import io.swagger.service.IngredientService;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-11-17T22:44:18.369Z")

@Controller
public class IngredientApiController implements IngredientApi {

    private static final Logger log = LoggerFactory.getLogger(IngredientApiController.class);

    private final HttpServletRequest request;
    
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private Search ingredientSearch;
    
    

    @org.springframework.beans.factory.annotation.Autowired
    public IngredientApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.request = request;
    }

    public ResponseEntity<Ingredient> addIngredient(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Ingredient ingredient) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	Ingredient ingredientDB = ingredientService.createIngredient(ingredient);
            return new ResponseEntity<Ingredient>(ingredientDB, HttpStatus.OK);
        }

        return new ResponseEntity<Ingredient>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<IngredientListResponse> getAllIngredient(@ApiParam(value = "search keyword.") @Valid @RequestParam(value = "q", required = false) String q) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	IngredientListResponse ingredientListResponse = new IngredientListResponse();
        	log.info("q------>"+q);
            if(null == q) {
            		List<Ingredient> ingredients = ingredientService.getAllIngredients();
            		
            		ingredientListResponse.setIngredients(ingredients);
            }else {
            	List<Ingredient> ingredients = ingredientSearch.searchIngredient(q);
            	ingredientListResponse.setIngredients(ingredients);
            }
                return new ResponseEntity<IngredientListResponse>(ingredientListResponse, HttpStatus.OK);
        }

        return new ResponseEntity<IngredientListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ingredient> getIngredient(@ApiParam(value = "The ingredient ID.",required=true) @PathVariable("ingredient_id") Integer ingredientId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	log.info("get ingredient----->>>"+ingredientId);
            Ingredient ingredient = ingredientService.getIngredient(ingredientId);
            if(null== ingredient) {
            	throw new IngredientNotFoundException(ingredientId + "-id: Not Found");
            }
            return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
        }

        return new ResponseEntity<Ingredient>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Ingredient> updateIngredient(@ApiParam(value = "The ingredient ID.",required=true) @PathVariable("ingredient_id") Integer ingredientId,@ApiParam(value = ""  )  @Valid @RequestBody Ingredient ingredient) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
        	log.info("get ingredient----->>>"+ingredientId);
        	Ingredient ingredientDB = ingredientService.getIngredient(ingredientId);
        	ingredientDB.setName(ingredient.getName());
        	ingredientService.updateIngredient(ingredientDB);
            return new ResponseEntity<Ingredient>(ingredientDB, HttpStatus.OK);
        }

        return new ResponseEntity<Ingredient>(HttpStatus.NOT_IMPLEMENTED);
    }

}
