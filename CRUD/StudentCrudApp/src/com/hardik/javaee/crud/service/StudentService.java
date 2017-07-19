package com.hardik.javaee.crud.service;

import java.util.List;

import com.hardik.javaee.crud.model.Student;

/**
 * Student Service Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface StudentService {
	public List<Student> getAllStudents();

	public Student getStudentById(Integer id);

	public Integer save(Student student);

	public Boolean update(Student student);

	public Boolean delete(Integer id);
}
