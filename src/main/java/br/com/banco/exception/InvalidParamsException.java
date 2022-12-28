package br.com.banco.exception;

import java.io.Serializable;

public class InvalidParamsException extends RuntimeException implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	public InvalidParamsException(String message) {
		super(message);
	}


}
