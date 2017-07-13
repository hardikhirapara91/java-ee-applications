<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hardik.javaee.util.DbUtils"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String username = request.getParameter("username");
	if(username != null && !username.isEmpty()){
		// DB Connection
		DbUtils dbUtils = new DbUtils();
		Connection connection = dbUtils.getConnection();
		String query = "SELECT `id` FROM `user` WHERE `username`=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			out.print(true);
		} else {
			out.print(false);
		}
		dbUtils.closeConnection();
	}
%>