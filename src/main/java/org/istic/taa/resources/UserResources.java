package org.istic.taa.resources;

import org.istic.taa.aspect.LogAspect;
import org.istic.taa.domain.User;
import org.istic.taa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by stephane on 05/10/15.
 */
@RestController
public class UserResources {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogAspect logger;

    @RequestMapping(value = "/users/:id", method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<User> getUser() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(User u) {
        userRepository.save(u);
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(User u) {
        userRepository.save(u);
    }

    @RequestMapping(value = "/users/:id", method = RequestMethod.DELETE)
    public void deleteUser(@PathParam("id") Long id) {
        userRepository.delete(id);
    }

}

