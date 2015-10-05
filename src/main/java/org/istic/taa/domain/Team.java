package org.istic.taa.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by stephane on 02/10/15.
 */
@Entity
public class Team {

    private Long id;

    private String name;

    private Set<User> users;
    private Sprint sprint;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "team")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToOne(mappedBy = "team")
    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

