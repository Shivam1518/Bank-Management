package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentServiceInterface 
{
	public List<Student> getStudents();
	public void addStudents(Student student);
	public List<Student> deleteStudents(int id);
	public List<Student> updateStudent(Student student);

}
