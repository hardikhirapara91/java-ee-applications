package com.hardik.javaee.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hardik.javaee.crud.model.Student;
import com.hardik.javaee.crud.util.DbUtils;

/**
 * Student DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudents() throws ClassNotFoundException, SQLException {
		List<Student> students = new ArrayList<>();
		Connection connection = DbUtils.getConnection();
		String query = "SELECT * FROM `students`";

		if (connection != null) {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student student = new Student();
				student.setRlno(resultSet.getInt("rlno"));
				student.setFirstName(resultSet.getString("first_name"));
				student.setLastName(resultSet.getString("last_name"));
				student.setStandard(resultSet.getString("standard"));
				student.setDivision(resultSet.getString("division"));
				student.setEmail(resultSet.getString("email"));
				students.add(student);
			}
			resultSet.close();
			statement.close();
		}

		return students;
	}

	@Override
	public Student getStudentById(Integer id) throws ClassNotFoundException, SQLException {
		Student student = new Student();
		Connection connection = DbUtils.getConnection();
		String query = "SELECT * FROM `students` WHERE `rlno`=?";

		if (connection != null) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				student.setRlno(id);
				student.setFirstName(resultSet.getString("first_name"));
				student.setLastName(resultSet.getString("last_name"));
				student.setStandard(resultSet.getString("standard"));
				student.setDivision(resultSet.getString("division"));
				student.setEmail(resultSet.getString("email"));

			}
			resultSet.close();
			statement.close();
		}

		return student;
	}

	@Override
	public Integer save(Student student) throws ClassNotFoundException, SQLException {
		Connection connection = DbUtils.getConnection();
		String query = "INSERT INTO `students`(`first_name`,`last_name`,`standard`,`division`,`email`) VALUES(?,?,?,?,?)";

		if (connection != null) {
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getStandard());
			statement.setString(4, student.getDivision());
			statement.setString(5, student.getEmail());
			statement.executeUpdate();

			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				return resultSet.getInt(1);
			}
			resultSet.close();
			statement.close();
		}

		return 0;
	}

	@Override
	public Boolean update(Student student) throws ClassNotFoundException, SQLException {
		Connection connection = DbUtils.getConnection();
		String query = "UPDATE `students` SET `first_name`=?, `last_name`=?, `standard`=?, `division`=?, `email`=? WHERE `rlno`=?";

		if (connection != null) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getStandard());
			statement.setString(4, student.getDivision());
			statement.setString(5, student.getEmail());
			statement.setInt(6, student.getRlno());
			if (statement.executeUpdate() > 0) {
				return true;
			}
			statement.close();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection connection = DbUtils.getConnection();
		String query = "DELETE FROM `students` WHERE `rlno`=?";

		if (connection != null) {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			if (statement.executeUpdate() > 0) {
				return true;
			}
			statement.close();
		}
		return false;
	}

}
