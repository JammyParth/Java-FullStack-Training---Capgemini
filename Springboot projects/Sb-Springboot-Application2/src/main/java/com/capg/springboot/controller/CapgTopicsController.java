package com.capg.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CapgTopicsController {

    @Autowired
    private CapgTopicsService topicService;

    @RequestMapping("/myController")
    public String display() {
        return "My Controller";
    }

    @GetMapping("/capgtopics")
    public List<CapgTopics> getAllTopics(){
        return topicService.getAllMyTopics();
    }

    @PostMapping("/capgtopics")
    public void addTopic(@RequestBody CapgTopics topics) {
        topicService.addTopic(topics);
    }
}