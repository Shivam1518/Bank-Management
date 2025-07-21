package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentServiceInterface;

@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	StudentServiceInterface service;
	
	@GetMapping("/fetch") 
	public List<Student> getStudents()
	{
		return service.getStudents();
	} 
	
	@PostMapping("/add")
	public String addStudents(@RequestBody Student student)
	{
		try
		{
			service.addStudents(student);
			return "Student Added Successfully";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Some Error Occured";
		}
	}
	
	
	@DeleteMapping("/delete/{id}")
	public List<Student> deleteStudents(@PathVariable ("id") int id)
	{
		return service.deleteStudents(id);
		
	}
	
	@PutMapping("/update")
	public List<Student> updateStudents(@RequestBody Student student)
	{
		return service.updateStudent(student);
	}
		 
	
//	@GetMapping("/home")
//	public String home()
//	{
//		return "Student home";
//	}
//	
	
	
//	
//	@GetMapping("/Sum/{num1}/{num2}")
//	public String getSum(@PathVariable("num1") int a,@PathVariable("num2") int b)
//	{
//		return service.getSum(a, b);
//	} 
//	
//	
//	@GetMapping("/multi")
//	public String getMulti(@RequestParam("num1") int a,@RequestParam("num2") int b)
//	{
//		return service.getMul(a, b); 
//	} 

} 
