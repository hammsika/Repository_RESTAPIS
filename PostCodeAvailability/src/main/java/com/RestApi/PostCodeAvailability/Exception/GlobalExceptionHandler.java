package com.RestApi.PostCodeAvailability.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(PostCodeNotFoundException.class)
	public ResponseEntity<Error> handlePostCodeNotFound(PostCodeNotFoundException e,WebRequest request)
	{
		
		Error ee=new Error(HttpStatus.NOT_FOUND,e.getMessage());
		return new ResponseEntity<Error>(ee, HttpStatus.NOT_FOUND);
	}
	

}
