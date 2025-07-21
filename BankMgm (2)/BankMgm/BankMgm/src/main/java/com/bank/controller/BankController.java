package com.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.model.AccountHolder;
import com.bank.service.BankServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bank")
public class BankController 
{
	@Autowired 
	BankServices service;
	
	@PostMapping("/save")
	public List<AccountHolder> addAccount(@Valid @RequestBody AccountHolder account)
	{
		return service.addAccount(account);
	}
	 
	
	@GetMapping("/fetch")
	public List<AccountHolder> getAccounts()
	{
		return service.getAccounts();
	}
	
	 
//	@PutMapping("/update")
//	public List<AccountHolder> updateAccount(@RequestParam("amount") float amount,@RequestParam("id") int id)
//	{
//		return service.updateAccount(amount, id);  
//	}
	
	@PutMapping("/update")
	public ResponseEntity<List<AccountHolder>> updateAccount(@RequestParam("amount") float amount,@RequestParam("id") int id)
	{
		List<AccountHolder> accounts = service.updateAccount(amount,id);  
		
		if(accounts == null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accounts);
		} 
		else 
		{
			return ResponseEntity.status(HttpStatus.OK).body(accounts);
		}
	}
	
//	@DeleteMapping("/delete/{id}")
//	public List<AccountHolder> deleteAccount(@PathVariable("id") int id)
//	{
//		return service.deleteAccount(id);
//	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<AccountHolder>> deleteAccount(@PathVariable("id") int id)
	{
		List<AccountHolder> accounts = service.deleteAccount(id);  
		if(accounts == null) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body(accounts);
		}
	}

	
	
	
	
	 
	@GetMapping("/getbyname/{fname}")
	public List<AccountHolder> getByName(@PathVariable("fname") String fname)
	{
		return service.getByName(fname);
	}
	
	@GetMapping("/getbyname/{fname}/{id}")
	public List<AccountHolder> getByFnameAndId(@PathVariable("fname") String fname,@PathVariable("id")int id)
	{
		return service.getByFnameAndId(fname,id);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> methodInvalidArgumentException(MethodArgumentNotValidException ex)
	{
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((err)->{
			errors.put(err.getField(), err.getDefaultMessage());
		});
		return errors;
	}
	 
	@GetMapping("/admin")
	public String adminApi()
	{
		return "Admin Api";
	}
	
	@GetMapping("/user")
	public String userApi()
	{
		return "User Api";
	}
	
	
	 
	
}
