package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Course;

public class CourseDAO {
	
	
	public   List<Course> selectCourseByPriceAndDuration(double price,int duration) throws Exception{
		System.out.println("Inside selectCourseByPriceAndDuration()");
		List<Course> courses = new ArrayList<Course>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcc","root","secl2015");
		PreparedStatement statement = connection.prepareStatement("select * from course_detail where c_price >= ? and c_duration >= ?");
		statement.setDouble(1, price);
		statement.setInt(2, duration);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Course course = new Course();
			course.setId(resultSet.getInt(1));
			course.setTitle(resultSet.getString(2));
			course.setPrice(resultSet.getDouble(3));
			course.setDuration(resultSet.getInt(4));
			courses.add(course);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return courses;
	}
	
	
	public  Course selectCourseByID(int id) throws Exception{
		Course course = new Course();
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcc","root","secl2015");
		PreparedStatement statement = connection.prepareStatement("select * from course_detail where c_id=?");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
		
			course.setId(resultSet.getInt(1));
			course.setTitle(resultSet.getString(2));
			course.setPrice(resultSet.getDouble(3));
			course.setDuration(resultSet.getInt(4));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
	
		
		return course;
	}
	
	public  Course selectCourseByTitle(String title) throws Exception{
		Course course = new Course();
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcc","root","secl2015");
		PreparedStatement statement = connection.prepareStatement("select * from course_detail where c_title like ?");
		statement.setString(1, "%"+title);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
		
			course.setId(resultSet.getInt(1));
			course.setTitle(resultSet.getString(2));
			course.setPrice(resultSet.getDouble(3));
			course.setDuration(resultSet.getInt(4));
			
		}
		resultSet.close();
		statement.close();
		connection.close();
	
		
		return course;
	}
			
	public  Course selectCourse() throws Exception{
		Course course = new Course();
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcc","root","secl2015");
		PreparedStatement statement = connection.prepareStatement("select * from course_detail where c_id=1");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
		
			course.setId(resultSet.getInt(1));
			course.setTitle(resultSet.getString(2));
			course.setPrice(resultSet.getDouble(3));
			course.setDuration(resultSet.getInt(4));
	
		}
		resultSet.close();
		statement.close();
		connection.close();
		return course;
	}
	
	
	public  List<Course> selectAll() throws Exception{
		List<Course> courses = new ArrayList<Course>();
		Class.forName("com.mysql.jdbc.Driver");
		Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcc","root","secl2015");
		PreparedStatement statement = connection.prepareStatement("select * from course_detail");
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Course course = new Course();
			course.setId(resultSet.getInt(1));
			course.setTitle(resultSet.getString(2));
			course.setPrice(resultSet.getDouble(3));
			course.setDuration(resultSet.getInt(4));
			courses.add(course);
		}
		resultSet.close();
		statement.close();
		connection.close();
		return courses;
	}

}
