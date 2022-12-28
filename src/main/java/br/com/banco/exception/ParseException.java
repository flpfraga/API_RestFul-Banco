package br.com.banco.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ParseException extends RuntimeException implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	public ParseException(String message) {
		super(message);
	}

}
