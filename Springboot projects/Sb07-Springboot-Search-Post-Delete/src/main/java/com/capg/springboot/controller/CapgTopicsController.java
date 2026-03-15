package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CapgTopicsController {
	
	
	@Autowired
	CapgTopicsService topicService;
	
	@RequestMapping("/myController")
	public String display() {
		return ("My Controller");
	}
	
	
	
	//GET all topics
	@RequestMapping("/capgtopics")
	public List<CapgTopics> getAllTopics(){
		
		return topicService.getAllMyTopics();
	}
	
	
	//Topic by ID
	@RequestMapping("/capgtopics/{id}")
	public CapgTopics getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value  = "/capgtopics")
	
	public void addTopic(@RequestBody CapgTopics topic) {
		topicService.addTopic(topic);
	}
	
	
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/topics{id}")
	
	public void deleteTopic(@RequestBody CapgTopics topic , String id) {
		topicService.deleteTopic(id);
	}
	
	
	
}
