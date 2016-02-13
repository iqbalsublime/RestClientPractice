package com.example.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Course {
	
	int id;
	String title;
	double price;
	int duration;
	
	public Course() {
	}
	
	public Course(String title, double price, int duration) {
		this.title = title;
		this.price = price;
		this.duration = duration;
	}
	
	public Course(int id, String title, double price, int duration) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

}
