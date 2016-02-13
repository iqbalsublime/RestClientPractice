package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Course;

public class CourseDAO_backup {
	
	List<Course> courses = null;
	
	public CourseDAO_backup() {
		courses = new ArrayList<Course>();
		courses.add(new Course(100, "Hibernate", 43000.00, 40));
		courses.add(new Course(200, "Spring", 33000.00, 70));
		courses.add(new Course(300, "Cocoon", 67000.00, 40));
		courses.add(new Course(400, "Lucene", 89000.00, 80));
		courses.add(new Course(500, "SEAM", 73000.00, 20));
		courses.add(new Course(600, "SEAM", 73000.00, 20));
		courses.add(new Course(700, "SEAM", 73000.00, 20));
		courses.add(new Course(800, "SEAM", 73000.00, 20));
		courses.add(new Course(900, "SEAM", 73000.00, 20));
	
	}
			
	public  Course selectCourse(){
		//JDBC logic
		return new Course(100, "Hibernate", 43000.00, 40);
	}
	
	public  Course selectCourseByPriceAndDuration(double price, int duration){
		Course course = null;
		for(Course c: courses){
			if(c.getPrice() >= price && c.getDuration() >= duration){
				course = c;
				break;
			}
		}
		return course;
	}
	
	public  Course selectCourseById(int id){
		Course course = null;
		for(Course c: courses){
			if(c.getId() == id){
				course = c;
				break;
			}
		}
		return course;
	}
	
	
	public  List<Course> selectAll(){
		return courses;
	}

}
