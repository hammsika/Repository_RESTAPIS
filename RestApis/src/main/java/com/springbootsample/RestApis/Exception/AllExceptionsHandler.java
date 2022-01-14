package com.springbootsample.RestApis.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AllExceptionsHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleStudentNotFoundException(StudentNotFoundException ex,WebRequest request)
	{
		ExceptionResponse ec=new ExceptionResponse(new Date(),"Student Not Found",request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(ec,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex,WebRequest request)
	{
		ExceptionResponse ec=new ExceptionResponse(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionResponse>(ec,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
