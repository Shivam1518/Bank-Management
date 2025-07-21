package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.student.model.Student;

@Service 
public class StudentService implements StudentServiceInterface
{ 
	
	List<Student> students;
	
	public StudentService()
	{
		students = new ArrayList<Student>();
		
		students.add(new Student(101,"Ravindra","Patel"));
		students.add(new Student(102,"Mayank","Pal"));
		students.add(new Student(103,"Kalpesh","Bari"));
		students.add(new Student(104,"Manas","Patil"));
		students.add(new Student(104,"Sheetal","Panja"));
	}
	
	public List<Student> getStudents()

	{
		return this.students;
	}

	public void addStudents(Student student) 
	{ 
		this.students.add(student);
	}

	public List<Student> deleteStudents(int id) 
	{
		for(Student std : students)
		{
			if(std.getId() ==id)
			{
				students.remove(std);
				break;
			}
		}
		return this.students;
	}

	public List<Student> updateStudent(Student student) 
	{
		for(Student std : students)
		{
			if(std.getId() ==student.getId())
			{
				std.setFname(student.getFname());
				std.setLname(student.getLname());
				break;
			}
		}
		return this.students;
	}
	
	
	
	
//	public String getSum(int a, int b)
//	{
//		return "Sum is "+ (a+b); 
//	}
//	
//	public String getMul(int a, int b)
//	{
//		return "Multiplicatioin is "+ (a*b); 
//	}

}
