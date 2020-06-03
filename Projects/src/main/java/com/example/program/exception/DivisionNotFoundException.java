package com.example.program.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Division Not Found") //404
public class DivisionNotFoundException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;

	public DivisionNotFoundException(int id){
		super("Division with id="+id);
	}
	
	public DivisionNotFoundException(String name){
		super("Division with name="+name);
	}
}