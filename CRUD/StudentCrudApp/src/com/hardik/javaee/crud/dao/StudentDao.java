package com.hardik.javaee.crud.dao;

import java.sql.SQLException;
import java.util.List;

import com.hardik.javaee.crud.model.Student;

/**
 * Student DAO Interface
 * 
 * @author HARDIK HIRAPARA
 *
 */
public interface StudentDao {
	public List<Student> getAllStudents() throws ClassNotFoundException, SQLException;

	public Student getStudentById(Integer id) throws ClassNotFoundException, SQLException;

	public Integer save(Student student) throws ClassNotFoundException, SQLException;

	public Boolean update(Student student) throws ClassNotFoundException, SQLException;

	public Boolean delete(Integer id) throws ClassNotFoundException, SQLException;

}
