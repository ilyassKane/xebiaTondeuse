package com.xebia.xebia_tondeuse;

public class InvalidFileException extends RuntimeException {
	
	private String message;
	
	public InvalidFileException(String message) {
		this.message=message;
	}

}
