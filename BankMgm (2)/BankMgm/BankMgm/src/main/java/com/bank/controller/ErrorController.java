package com.bank.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bank.exceptions.AccountDoesNotExist; 


@RestControllerAdvice
public class ErrorController 
{
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodInvalidArgumentException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((err)->{
			errors.put(err.getField(), err.getDefaultMessage());
		});
		return errors;
	}
	
	
	
	@ExceptionHandler(AccountDoesNotExist.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> accountDoesNotExist(AccountDoesNotExist ex)
	{
		Map<String, String> errors = new HashMap<>();
		
		errors.put("error", ex.getMessage());
		
		return errors;
	}
	

}
