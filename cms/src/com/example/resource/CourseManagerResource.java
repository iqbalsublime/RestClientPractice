package com.example.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.dao.CourseDAO;
import com.example.model.Course;

//URI --- http://ipaddress:5000/cms/rest/courses
@Path("courses")
public class CourseManagerResource {
	
	CourseDAO courseDAO = new CourseDAO(); 


	//URI --- http://ipaddress:5000/cms/rest/courses/course?pr=20000.00&dur=30 (GET)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("price")
	public List<Course> readCourseByPrice(@QueryParam("pr") double price,@QueryParam("dur") int duration){
		System.out.println("Inside readCourseByPrice()");
		try {
			return courseDAO.selectCourseByPriceAndDuration(price, duration);	
		} catch (Exception e) {
			
		}
		return null;
	}
	
	
	//URI --- http://ipaddress:5000/cms/rest/courses/course?id=200 (GET)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("course")
	public Course readCourseID(@QueryParam("id") int id){
		System.out.println("Inside readCourseID()");
		try {
			return courseDAO.selectCourseByID(id);	
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("coursebytitle")
	public Course readCourseIdByTitle(@QueryParam("title") String title){
		System.out.println("Inside readCourseIdByTitle()");
		try {
			return courseDAO.selectCourseByTitle(title);	
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	
	@Path("all")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public List<Course> readAllCourseAsXML(){
		System.out.println("Inside readAllCourseAsXML()");
	
		try {
			return courseDAO.selectAll();	
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	//URI --- http://ipaddress:5000/cms/rest/courses/all (GET)
	@Path("all")
	@GET
	@Produces({MediaType.APPLICATION_JSON,"text/json"})
	public List<Course> readAllCourseAsJSON(){
		System.out.println("Inside readAllCourseAsJSON()");
		try {
			return courseDAO.selectAll();	
		} catch (Exception e) {
			
		}
		return null;
	}

	
	//URI --- http://ipaddress:5000/cms/rest/courses (GET)
	@GET
	@Produces("text/plain")
	public String readCourse(){
		System.out.println("Inside readCourse()");
		return "ID: 101, Title: DOJO, Price: 25000.00, Duration: 7 Days";
	}
	

	//URI --- http://ipaddress:5000/cms/rest/courses (GET)
	//@GET
	//@Produces("text/xml")
	/*@Produces({"text/xml","application/xml"})
	public String readCourseAsXML(){
		System.out.println("Inside readCourseAsXML()");
		return "<course><id>101</id><title>DOJO</title><price>25000.00</price><duration>7 Days</duration></course>";
	}*/

	@GET
	@Produces({"text/xml","application/xml"})
	public Course readCourseAsXML(){
		System.out.println("Inside readCourseAsXML()");
		try {
			return courseDAO.selectCourse();	
		} catch (Exception e) {
			
		}
		return null;
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,"text/json"})
	public Course readCourseAsJSON(){
		System.out.println("Inside readCourseAsJSON()");
		try {
			return courseDAO.selectCourse();	
		} catch (Exception e) {
			
		}
		return null;
	}
	
	//URI --- http://ipaddress:5000/cms/rest/courses (GET)
	//@GET
	//@Produces("text/json")
	//@Produces({"text/json","application/json"})
	/*@Produces({MediaType.APPLICATION_JSON,"text/json"})
	public String readCourseAsJSON(){
		System.out.println("Inside readCourseAsJSON()");
		return "{\"id\":101,\"title\":\"DOJO\",\"price\":25000.00,\"duration\":\"7 Days\"}";
	}*/
	
	
}
