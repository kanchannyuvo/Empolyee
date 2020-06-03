package com.example.program.exception;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		return "database_error";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		logger.error("IOException handler executed");

	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionJSONInfo handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		
		ExceptionJSONInfo response = new ExceptionJSONInfo();
		response.setUrl(request.getRequestURL().toString());
		response.setMessage(ex.getMessage());
		
		
		return response;
	}
}