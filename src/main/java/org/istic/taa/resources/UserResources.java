package org.istic.taa.resources;

import org.istic.taa.domain.User;
import org.istic.taa.repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by stephane on 05/10/15.
 */
@Path("/")
public class UserResources {

    private static final Logger logger = Logger.getLogger(UserResources.class.getName());
    //private EntityManager em = TeamManager.getEntityManager();

    @GET
    @Path("/users/:id")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Long id) {
        logger.info("Get user : " + id);
        //return em.find(User.class, id);
        return new User();
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUser() {
        //List<User> users = em.createQuery("SELECT u FROM User u").getResultList();
        List<User> users = new ArrayList<User>();
        logger.info("Get users");
        return users;
    }

    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User u) {
        logger.info("Add user : " + u.getName());
        //em.persist(u);
    }

    @PUT
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User t) {
        logger.info("Update user : " + t.getId());
    }

    @DELETE
    @Path("/users/:id")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("id") Long id) {
        logger.info("Delete user  with id : " + id);
        //User user = em.find(User.class, id);
        //em.remove(user);
    }
}
