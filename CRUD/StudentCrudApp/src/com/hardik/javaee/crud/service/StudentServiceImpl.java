package com.hardik.javaee.crud.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hardik.javaee.crud.dao.StudentDao;
import com.hardik.javaee.crud.dao.StudentDaoImpl;
import com.hardik.javaee.crud.model.Student;

/**
 * Student Service Implementation
 * 
 * @author silent
 *
 */
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao = new StudentDaoImpl();

	@Override
	public List<Student> getAllStudents() {
		try {
			return studentDao.getAllStudents();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Student>();
	}

	@Override
	public Student getStudentById(Integer id) {
		try {
			return studentDao.getStudentById(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new Student();
	}

	@Override
	public Integer save(Student student) {
		try {
			return studentDao.save(student);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Boolean update(Student student) {
		try {
			return studentDao.update(student);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		try {
			return studentDao.delete(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
