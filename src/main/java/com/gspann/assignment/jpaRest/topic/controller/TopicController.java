package com.gspann.assignment.jpaRest.topic.controller;

import com.gspann.assignment.jpaRest.topic.service.TopicService;
import com.gspann.assignment.jpaRest.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by chetan on 2/10/18.
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/linkedTopics")
    public List<Topic> findAllTopicsLinkedToAtLeastNTopics() {
        return topicService.findAllTopicsLinkedToAtLeastNTopics(1);
    }

    @GetMapping("/linkedTopicsWithChildAndParent")
    public List<Topic> findAllTopicsLinkedWithAChildAndParent() {
        return topicService.findAllTopicsLinkedWithAChildAndParent();
    }
}
