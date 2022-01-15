package com.RestApi.OfferProducts.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ExceptionMessage> handleException(ProductNotFoundException ex,WebRequest request)
	{
		ExceptionMessage ee=new ExceptionMessage(new Date(),"Proudct Not Found",request.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(ee, HttpStatus.NOT_FOUND);
	}

}
