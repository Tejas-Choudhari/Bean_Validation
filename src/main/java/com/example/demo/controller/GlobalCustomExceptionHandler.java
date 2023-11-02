package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.support.DefaultMessageSourceResolvable;
//import org.hibernate.mapping.Set;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalCustomExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	Responses response;

	/**
	 * print the data in the format of the list
	 */

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//		List<String> errors = new ArrayList<>();
//		ex.getBindingResult().getAllErrors().forEach(error -> {
//			if (error instanceof FieldError) {
//				String message = error.getDefaultMessage();
//				errors.add(message);
//			}
//		});
//		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
//	}

	/**
	 * print the data in the format of the JSON
	 */
	@ExceptionHandler({ MethodArgumentNotValidException.class })
	public ResponseEntity<Object> yourExceptionHandler(MethodArgumentNotValidException e) {

		List<String> defalutMessage = e.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
		String errorMessage = String.join(",", defalutMessage);

		// customizing the response for the application i.e. Error Code / Status / Error Message.
		response.setErrorCode("400");
		response.setStatus(" Status -> Falied");
		response.setErrorMessage(errorMessage);
		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * print the data in the format of key and default message
	 */

//		 Map<String, Object> response = new HashMap<>();
//	        BindingResult bindingResult = e.getBindingResult();
//	        Map<String, String> errors = new HashMap<>();   
//	        int count = bindingResult.getErrorCount(); 
//	        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//	        	errors.put(fieldError.getField(),fieldError.getDefaultMessage());
//	        }
//	        response.put("Errors", errors);

}
