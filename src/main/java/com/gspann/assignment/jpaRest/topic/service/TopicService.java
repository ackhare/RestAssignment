package com.gspann.assignment.jpaRest.topic.service;

/**
 * Created by chetan on 2/10/18.
 */

import com.gspann.assignment.jpaRest.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gspann.assignment.jpaRest.topic.repository.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TopicService {

    @Autowired
    TopicRepositoryImpl topicRepository;

    public List<Topic> findAllTopicsLinkedToAtLeastNTopics(int numberOfRelatedTopicsToCheck) {
        return topicRepository.findAllTopicsLinkedToAtLeastNTopics(numberOfRelatedTopicsToCheck);
    }

    public List<Topic> findAllTopicsLinkedWithAChildAndParent() {
        return topicRepository.findAllTopicsLinkedWithAChildAndParent();
    }
}
