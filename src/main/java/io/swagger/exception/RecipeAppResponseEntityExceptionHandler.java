package io.swagger.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.model.IngredientNotFoundException;
import io.swagger.model.RecipeNotFoundException;

@ControllerAdvice
@RestController
public class RecipeAppResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 	new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
	return  new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(IngredientNotFoundException.class)
	public final ResponseEntity<Object> IngredientNotFoundException(IngredientNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 	new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
	return  new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(RecipeNotFoundException.class)
	public final ResponseEntity<Object> RecipeNotFoundException(RecipeNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 	new ExceptionResponse(ex.getMessage(), new Date(), request.getDescription(false));
	return  new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);
	}
		@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = 	new ExceptionResponse("Validation failed",new Date(),ex.getBindingResult().getAllErrors().get(0).toString());

		return  new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
}
