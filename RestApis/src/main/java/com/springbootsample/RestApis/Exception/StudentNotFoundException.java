package com.springbootsample.RestApis.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
		private String resourceName;
		private String fieldName;
		private Object fieldValue;
		public StudentNotFoundException()
		{
			
		}
		public StudentNotFoundException(String resourceName, String fieldName, Object fieldValue) {
			super(String.format("%s Not Found With %s:%s", resourceName,fieldName,fieldValue));
			this.resourceName = resourceName;
			this.fieldName = fieldName;
			this.fieldValue = fieldValue;
		}
		public String getResourceName() {
			return resourceName;
		}
		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}
		public String getFieldName() {
			return fieldName;
		}
		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}
		public Object getFieldValue() {
			return fieldValue;
		}
		public void setFieldValue(Object fieldValue) {
			this.fieldValue = fieldValue;
		}
		
		
}
