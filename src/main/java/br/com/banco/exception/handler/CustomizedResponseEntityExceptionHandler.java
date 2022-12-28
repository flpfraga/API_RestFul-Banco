package br.com.banco.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.banco.data.error.ErrorMessage;
import br.com.banco.exception.InvalidParamsException;
import br.com.banco.exception.ParseException;
import br.com.banco.exception.ResourceNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorMessage> handleBadRequestExceptions(Exception ex) {
		ErrorMessage error = new ErrorMessage("Not Found!", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ParseException.class)
	public final ResponseEntity<ErrorMessage> handleNotAcceptableExceptions(Exception ex) {
		ErrorMessage error = new ErrorMessage("Not Found!", HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(InvalidParamsException.class)
	public final ResponseEntity<ErrorMessage> invalidParamsException(Exception ex) {
	    ErrorMessage error = new ErrorMessage("Invalid params",HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
	}
	
}
