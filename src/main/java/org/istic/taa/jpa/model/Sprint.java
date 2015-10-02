package org.istic.taa.jpa.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by stephane on 02/10/15.
 */
@Entity
public class Sprint {

    private Long id;

    private String comment;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Team team;

    private Set<Task> tasks;

    public Sprint() {

    }

    public Sprint(Team team, String comment, LocalDateTime startDate, LocalDateTime endDate) {
        this.team = team;
        this.comment = comment;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @ManyToOne
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Column
    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Column
    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Column
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
