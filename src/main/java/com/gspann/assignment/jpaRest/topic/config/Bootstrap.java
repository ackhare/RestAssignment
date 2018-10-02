package com.gspann.assignment.jpaRest.topic.config;

import com.gspann.assignment.jpaRest.topic.model.SubTopic;
import com.gspann.assignment.jpaRest.topic.model.Topic;
import com.gspann.assignment.jpaRest.topic.repository.SubTopicRepository;
import com.gspann.assignment.jpaRest.topic.repository.TopicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chetan on 2/10/18.
 */
@Service
public class Bootstrap implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final static int ONE_ELEMENT = 1;
    @Autowired
    TopicRepository topicRepository;

    @Autowired
    SubTopicRepository subTopicRepository;

    @Override
    @Transactional()
    public void afterPropertiesSet() throws Exception {
        LOG.info("Bootstrapping data...");

        createTopic();

        LOG.info("...Bootstrapping completed");
    }

    private void createTopic() {
        if (topicRepository.count() < ONE_ELEMENT) {
            Topic topicOne = new Topic("One");
            topicOne.addSubTopic(new SubTopic("one_subtopic_first"));
            topicOne.addSubTopic(new SubTopic("one_subtopic_second"));
            topicRepository.save(topicOne);
            Topic topicTwo = new Topic("Two");
            topicTwo.addSubTopic(new SubTopic("two_subtopic_first"));
            topicTwo.addSubTopic(new SubTopic("two_subtopic_second"));
            Set<Topic> collectionOfTopics = new HashSet<>();
            collectionOfTopics.add(topicTwo);
            topicOne.setRelatedTopics(collectionOfTopics);
            topicRepository.save(topicTwo);
            topicRepository.save(topicOne);
        }
    }

}
