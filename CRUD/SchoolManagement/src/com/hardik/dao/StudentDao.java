package com.hardik.dao;

import java.util.List;

import com.hardik.bean.Student;

/**
 * Student DAO Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface StudentDao {
	public List<Student> getStudents();

	public boolean addStudent(Student student);

	public Student getStudentById(Integer id);

	public boolean updateStudent(Student student);

	public void deleteStudent(Integer id);
}
