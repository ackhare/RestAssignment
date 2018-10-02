package com.gspann.assignment.jpaRest.topic.model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by chetan on 2/10/18.
 */
@Entity
public class Topic {


    @Id
    @GeneratedValue
    @Column(name = "topic_id")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private Set<SubTopic> subTopics = new HashSet<>();

    //These are topics related to this topic so this class will be parent of relatedTopic
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "topic_relatedTopic",
            joinColumns = {@JoinColumn(name = "topic_id")},
            inverseJoinColumns = {@JoinColumn(name = "relatedTopic_id")})
    private Set<Topic> relatedTopics = new HashSet<>();
    //These are parent of this topics which is that this topic is related to current topic
    @ManyToMany(mappedBy = "relatedTopics")
    private Set<Topic> parentTopics = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Topic() {
    }

    public Set<Topic> getRelatedTopics() {
        return relatedTopics;

    }

    public Topic(String name) {
        this.name = name;
    }

    public void setRelatedTopics(Set<Topic> relatedTopics) {

        this.relatedTopics = relatedTopics;
    }


    public Set<SubTopic> getSubTopics() {
        return subTopics;
    }

    public void setSubTopics(Set<SubTopic> subTopics) {
        this.subTopics = subTopics;
    }

    public void addSubTopic(SubTopic subTopic) {
        subTopics.add(subTopic);
        subTopic.setTopic(this);
    }

    public Set<Topic> getParentTopics() {
        return parentTopics;
    }

    public void setParentTopics(Set<Topic> parentTopics) {
        this.parentTopics = parentTopics;
    }
}



