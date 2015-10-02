package org.istic.taa.jpa.model;

import javax.persistence.*;

/**
 * Created by stephane on 02/10/15.
 */
@Entity
public class User {

    private Long id;

    private Team team;

    private String name;
    private String lastname;
    private String firstname;
    private Usertype type;

    public User() {

    }

    public User(String lastname, String firstname, Usertype type) {
        setName(firstname, lastname);
        this.lastname = lastname;
        this.firstname = firstname;
        this.type = type;
    }

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstname, String lastname) {
        this.name = firstname + " " + lastname;
    }

    @Column
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Column
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Column
    public Usertype getType() {
        return type;
    }

    public void setType(Usertype type) {
        this.type = type;
    }
}
