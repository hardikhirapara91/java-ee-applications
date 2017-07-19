package com.hardik.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hardik.bean.Student;
import com.hardik.util.DBConnection;
import com.hardik.util.DateUtil;
import com.mysql.jdbc.PreparedStatement;

/**
 * Student DAO Implementation
 * 
 * @author HARDIK HIRAPARA
 *
 */
public class StudentDaoImpl implements StudentDao {

	private Connection connection = null;

	/**
	 * Initialize Connection Instance Variable
	 */
	public StudentDaoImpl() {
		if (connection == null) {
			connection = DBConnection.getConnection();
		}
	}

	/**
	 * Get all students
	 */
	@Override
	public List<Student> getStudents() {
		List<Student> studentLists = new ArrayList<Student>();
		String queryString = "SELECT * FROM `student`";

		try {
			PreparedStatement psts = (PreparedStatement) connection
					.prepareStatement(queryString);
			ResultSet result = psts.executeQuery();
			while (result.next()) {
				Student student = new Student();
				student.setId(result.getInt("id"));
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				student.setDob(result.getDate("dob"));
				student.setEmail(result.getString("email"));
				studentLists.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return studentLists;
	}

	/**
	 * Get Student By Id
	 */
	@Override
	public Student getStudentById(Integer id) {
		String query = "SELECT * FROM `student` WHERE `id`=?";
		Student student = new Student();

		try {
			PreparedStatement psts = (PreparedStatement) connection
					.prepareStatement(query);
			psts.setInt(1, id);

			ResultSet result = psts.executeQuery();

			while (result.next()) {
				student.setId(result.getInt("id"));
				student.setFirstName(result.getString("first_name"));
				student.setLastName(result.getString("last_name"));
				student.setDob(result.getDate("dob"));
				student.setEmail(result.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	/**
	 * Add Students
	 */
	@Override
	public boolean addStudent(Student student) {
		String query = "INSERT INTO `student`(`first_name`,`last_name`,`email`,`dob`) VALUES (?,?,?,?)";
		boolean transactionStatus = false;

		try {

			PreparedStatement psts = (PreparedStatement) connection
					.prepareStatement(query);

			psts.setString(1, student.getFirstName());
			psts.setString(2, student.getLastName());
			psts.setString(3, student.getEmail());
			// Convert SQL Date to Util Date
			psts.setDate(4, DateUtil.convertUtilDateToSQLDate(student.getDob()));

			int result = psts.executeUpdate();

			if (result > 0) {
				transactionStatus = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return transactionStatus;
	}

	/**
	 * Update Student
	 */
	@Override
	public boolean updateStudent(Student student) {

		String query = "UPDATE `student` SET `first_name`=?,`last_name`=?,`email`=?,`dob`=? WHERE `id`=?";
		boolean transactionStatus = false;

		try {
			PreparedStatement psts = (PreparedStatement) connection
					.prepareStatement(query);
			psts.setString(1, student.getFirstName());
			psts.setString(2, student.getLastName());
			psts.setString(3, student.getEmail());
			// Convert SQL Date to Util Date
			psts.setDate(4, DateUtil.convertUtilDateToSQLDate(student.getDob()));
			psts.setInt(5, student.getId());

			int result = psts.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				transactionStatus = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return transactionStatus;
	}

	@Override
	public void deleteStudent(Integer id) {
		String query = "DELETE FROM `student` WHERE `id`=?";
		try {
			PreparedStatement psts = (PreparedStatement) connection
					.prepareStatement(query);
			psts.setInt(1, id);
			psts.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
