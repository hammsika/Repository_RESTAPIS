package com.RestApi.OfferProducts.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;
	
	public ProductNotFoundException(String message,HttpStatus status)
	{
		this.message=message;
		this.status=status;
		
	}
	

}
