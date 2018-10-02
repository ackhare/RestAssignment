package com.gspann.assignment.jpaRest.topic.service;

/**
 * Created by chetan on 2/10/18.
 */

import com.gspann.assignment.jpaRest.topic.model.Topic;
import com.gspann.assignment.jpaRest.topic.repository.TopicCustomRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicCustomRepositoryImpl topicRepositoryImpl;

    public List<Topic> findAllTopicsLinkedToAtLeastNTopics(int numberOfRelatedTopicsToCheck) {
        return topicRepositoryImpl.findAllTopicsLinkedToAtLeastNTopics(numberOfRelatedTopicsToCheck);
    }

    public List<Topic> findAllTopicsLinkedWithAChildAndParent() {
        return topicRepositoryImpl.findAllTopicsLinkedWithAChildAndParent();
    }
}
