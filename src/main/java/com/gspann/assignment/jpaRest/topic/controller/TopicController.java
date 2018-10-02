package com.gspann.assignment.jpaRest.topic.controller;

import com.gspann.assignment.jpaRest.topic.model.Topic;
import com.gspann.assignment.jpaRest.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(value = "/linkedTopics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Topic>> findAllTopicsLinkedToAtLeastNTopics() {
        return ResponseEntity
                .ok()
                .body(topicService.findAllTopicsLinkedToAtLeastNTopics(1));
    }

    @GetMapping("/linkedTopicsWithChildAndParent")
    public ResponseEntity<List<Topic>> findAllTopicsLinkedWithAChildAndParent() {
        return ResponseEntity
                .ok()
                .body(topicService.findAllTopicsLinkedWithAChildAndParent());

    }
}
