package com.hcl.exception;

public class ServerResponseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ServerResponseException(String message){
		super(message);
	}
}
