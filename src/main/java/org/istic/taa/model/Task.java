package org.istic.taa.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by stephane on 02/10/15.
 */
@Entity
public class Task {

    private Long id;

    private User user;
    private Sprint sprint;
    private Tasktype type;

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime deadline;
    private String comment;

    private Task parent;
    private Set<Task> children;

    public Task() {

    }

    public Task(String name, Tasktype type, LocalDateTime startDate, LocalDateTime deadline, String comment) {
        this.name = name;
        this.type = type;
        this.startDate = startDate;
        this.deadline = deadline;
        this.comment = comment;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    @Column
    public Tasktype getType() {
        return type;
    }

    public void setType(Tasktype type) {
        this.type = type;
    }

    @ManyToOne
    public Task getParent() {
        return parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    public Set<Task> getChildren() {
        return children;
    }

    public void setChildren(Set<Task> children) {
        this.children = children;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    @Column
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}

