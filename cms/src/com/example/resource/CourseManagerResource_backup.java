package com.example.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.example.dao.CourseDAO_backup;
import com.example.model.Course;

//URI --- http://ipaddress:5000/cms/rest/courses
@Path("coursesbackup")
public class CourseManagerResource_backup {
	
	CourseDAO_backup courseDAO = new CourseDAO_backup(); 
	
	@Path("all")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.TEXT_XML})
	public List<Course> readAllCourseAsXML(){
		System.out.println("Inside readAllCourseAsXML()");
		return courseDAO.selectAll();
	}
	
	//URI --- http://ipaddress:5000/cms/rest/courses/all (GET)
	@Path("all")
	@GET
	@Produces({MediaType.APPLICATION_JSON,"text/json"})
	public List<Course> readAllCourseAsJSON(){
		System.out.println("Inside readAllCourseAsJSON()");
		return courseDAO.selectAll();
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
		return courseDAO.selectCourse();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,"text/json"})
	public Course readCourseAsJSON(){
		System.out.println("Inside readCourseAsJSON()");
		return courseDAO.selectCourse();
	}
	
	
	@GET
	@Path("course")
	@Produces({MediaType.APPLICATION_JSON,"text/json"})
	public Course readCourseByIdAsJSON(@QueryParam("id") int id){
		System.out.println("Inside readCourseByIdAsJSON()");
		return courseDAO.selectCourseById(id);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("price")
	public Course readCourseByPrice(@QueryParam("pr") double price,@QueryParam("dur") int duration){
		System.out.println("Inside readCourseByPrice()");
		return courseDAO.selectCourseByPriceAndDuration(price, duration);
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
