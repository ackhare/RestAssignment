package com.gspann.assignment.jpaRest.topic.repository;

import com.gspann.assignment.jpaRest.topic.model.Topic;

import java.util.List;

/**
 * Created by chetan on 2/10/18.
 */
public interface TopicRepositoryCustom {
    public List<Topic> findAllTopicsLinkedToAtLeastNTopics(int numberOfRelatedTopicsToCheck);
    public List<Topic>  findAllTopicsLinkedWithAChildAndParent();
}
