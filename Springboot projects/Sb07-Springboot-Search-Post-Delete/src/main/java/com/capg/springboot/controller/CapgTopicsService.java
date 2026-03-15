package com.capg.springboot.controller;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CapgTopicsService {

    private List<CapgTopics> topics = Arrays.asList(
            new CapgTopics("Springboot", "Spring MVC", "Spring"),
            new CapgTopics("J2SE tech", "JDBC", "Angular"),
            new CapgTopics("UI tech", "Angular 6", "React")
    );

    private List<CapgTopics> myTopics = new ArrayList<>(topics);

    public List<CapgTopics> getAllMyTopics(){
        return myTopics;
    }

    public void addTopic(CapgTopics topic) {
        myTopics.add(topic);
    }
    
    
    
    //Search 
    public CapgTopics getTopic(String id) {
    	return (CapgTopics) topics.stream()
    			.filter(t -> ((CapgTopics) t)
    			.getId()
    			.equals(id))
    			.findFirst()
    			.get();
    }
    
    
//    Delete
    
    public void deleteTopic(String id) {
    	topics.removeIf(t -> ((CapgTopics) t).getId().equals(id));
    }
    
    
}