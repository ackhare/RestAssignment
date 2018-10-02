package com.gspann.assignment.jpaRest.topic.repository;

import com.gspann.assignment.jpaRest.topic.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by chetan on 2/10/18.
 */
@Repository
public interface  TopicRepository extends CrudRepository<Topic, Long> {

    List<Topic> findAllByRelatedTopics(Set<Topic> relatedTopics);
}
