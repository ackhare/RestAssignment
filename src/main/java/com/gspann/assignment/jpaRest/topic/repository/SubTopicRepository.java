package com.gspann.assignment.jpaRest.topic.repository;

import com.gspann.assignment.jpaRest.topic.model.SubTopic;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by chetan on 2/10/18.
 */
@Repository
public interface SubTopicRepository extends CrudRepository<SubTopic, Long> {
}
