package com.hcl.exception;

public class ResponseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ResponseException(String message){
		super(message);
	}
}
