package com.example;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class Main {
	
	public static void main(String[] args) {
		
		//String uri = "http://10.106.8.81:8280/cms/3.0.0";
		String uri = "http://192.168.2.167:8280/cms/4.0.0";
		//String uri = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=44db6a862fba0b067b1930da0d769e98";
		//String uri = "http://jsonplaceholder.typicode.com/users";
		
		Client client = Client.create();
		WebResource resource = client.resource(uri);
		//String data = resource.get(String.class);
		//String data = resource.header("Authorization","Bearer 8aa95dd727f4f7b8f77efe38d95b9d88").get(String.class);
		//String data = resource.header("Accept", "text/xml").header("Authorization","Bearer 8aa95dd727f4f7b8f77efe38d95b9d88").get(String.class);
		//String data = resource.accept("application/json").header("Authorization","Bearer 8aa95dd727f4f7b8f77efe38d95b9d88").get(String.class);
		//String data = resource.accept("application/json").header("Authorization","Bearer 8aa95dd727f4f7b8f77efe38d95b9d88").get(String.class);
		String data = resource.path("all").header("Accept", "application/json").header("Authorization","Bearer 25e15e92b06ba33bcd159c2d9a618423").get(String.class);
		//String data = resource.header("Accept", "application/json").header("Authorization","Bearer 8aa95dd727f4f7b8f77efe38d95b9d88").get(String.class);
		//String data = resource.path("all").header("Accept", "application/xml").header("Authorization","Bearer 25e15e92b06ba33bcd159c2d9a618423").get(String.class);
	//	String data = resource.path("coursebytitle").queryParam("title", "Ja").header("Accept", "application/json").header("Authorization","Bearer 25e15e92b06ba33bcd159c2d9a618423").get(String.class);
		//String data = resource.path("price").queryParam("pr", "50000").queryParam("dur", "20").header("Accept", "application/json").header("Authorization","Bearer 25e15e92b06ba33bcd159c2d9a618423").get(String.class);
		System.out.println(data);
		
		
	}

}
