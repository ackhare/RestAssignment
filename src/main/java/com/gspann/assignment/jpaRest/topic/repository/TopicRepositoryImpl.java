package com.gspann.assignment.jpaRest.topic.repository;

import com.gspann.assignment.jpaRest.topic.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chetan on 2/10/18.
 */
@Repository
public class TopicRepositoryImpl implements TopicRepositoryCustom {
    @Autowired
    TopicRepository topicRepository;
    /*
    In this code we simply check if related topics exist in database then
    we see if number of those matches our input argument in greaterThanEqualcriteria
     */
    @Override
    public List<Topic> findAllTopicsLinkedToAtLeastNTopics(int numberOfRelatedTopicsToCheck) {
        List<Topic> resultantList = new ArrayList<>();
        topicRepository.findAll().forEach(topic -> {
            if (!topic.getRelatedTopics().isEmpty()) {
                if (topicRepository.findAllByRelatedTopics(topic.getRelatedTopics()).size() >= numberOfRelatedTopicsToCheck)
                    resultantList.add(topic);
            }
        });
        return resultantList;
    }
    /*
    In this code we simply check if related topics exist in database which are child and parenttopic
    exists in database, if there are then we got our topic
     */
    @Override
    public List<Topic> findAllTopicsLinkedWithAChildAndParent() {
        List<Topic> resultantList = new ArrayList<>();
        topicRepository.findAll().forEach(topic -> {
            if (!topic.getRelatedTopics().isEmpty() && !topic.getParentTopics().isEmpty()) {
                resultantList.add(topic);
            }
        });
        return resultantList;
    }
}
