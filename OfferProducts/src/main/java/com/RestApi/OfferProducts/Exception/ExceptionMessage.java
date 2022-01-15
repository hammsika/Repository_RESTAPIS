package com.RestApi.OfferProducts.Exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessage {
	private Date timestamp;
	private String filedname;
	private Object fieldvalue;

}
