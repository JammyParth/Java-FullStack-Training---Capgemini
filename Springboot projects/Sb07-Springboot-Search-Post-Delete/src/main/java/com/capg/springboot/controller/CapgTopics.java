package com.capg.springboot.controller;

public class CapgTopics {
	
	private String name;
	private String description;
	private String id;
	
//	CapgTopics(){  //default constructor
//		 
//	}
	
	public CapgTopics(String name, String description ,String id){
		super();
		this.name = name;
		this.description = description;
		this.id = id;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	 
}
