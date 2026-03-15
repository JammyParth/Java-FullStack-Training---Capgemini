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
}