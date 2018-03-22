package com.hardik.javaee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hardik.javaee.bean.Student;

/**
 * Student
 */
@WebServlet("/Student")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> JSONROOT = new HashMap<String, Object>();

	/**
	 * POST
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		response.setContentType("application/json");

		try {
			List<Student> students = new ArrayList<Student>();
			students.add(new Student(1, "Hardik", "Computer"));
			students.add(new Student(2, "Devin", "Mechanical"));
			students.add(new Student(3, "Parth", "Physics"));
			students.add(new Student(4, "Hitesh", "Electronic"));
			students.add(new Student(5, "Harsh", "Teaching"));
			students.add(new Student(6, "Deep", "Computer"));
			students.add(new Student(7, "Jay", "Computer"));
			students.add(new Student(8, "Krish", "Computer"));
			students.add(new Student(9, "Jemmy", "Computer"));
			students.add(new Student(10, "Shrujan", "Computer"));

			JSONROOT.put("Result", "OK");
			JSONROOT.put("Records", students);

			String jsonArray = gson.toJson(JSONROOT);
			System.out.println(jsonArray);
			response.getWriter().print(jsonArray);
		} catch (Exception ex) {
			JSONROOT.put("Result", "ERROR");
			JSONROOT.put("Message", ex.getMessage());
			String error = gson.toJson(JSONROOT);
			response.getWriter().print(error);
		}
	}

	/**
	 * GET
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
