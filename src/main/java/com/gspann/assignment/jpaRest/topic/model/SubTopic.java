package com.gspann.assignment.jpaRest.topic.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Created by chetan on 2/10/18.
 */
@Entity
public class SubTopic {


    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Id
    @GeneratedValue
    @Column(name = "subTopic_id")

    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public SubTopic() {
    }

    public Long getId() {
        return id;
    }

    public SubTopic(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubTopic)) return false;
        return id != null && id.equals(((SubTopic) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "SubTopic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
