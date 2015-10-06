package org.istic.taa.resources;

import org.istic.taa.domain.User;
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

    private static final Logger logger = Logger.getLogger(UserResources.class.getName());

    @RequestMapping(value = "/users/:id", method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Long id) {
        logger.info("Get user : " + id);
        return new User();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUser() {
        logger.info("Get users");
        return new ArrayList<User>();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(User t) {
        logger.info("Add user : " + t.getName());
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(User t) {
        logger.info("Update user : " + t.getId());
    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public void deleteUser(@PathParam("id") Long id) {
        logger.info("Delete user  with id : " + id);
    }

}

