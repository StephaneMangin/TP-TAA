package org.istic.taa.jaxrs.resources;

import org.istic.taa.domain.User;
import java.util.logging.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by stephane on 05/10/15.
 */
@Path("/")
public class UserResources {

    private static final Logger logger = Logger.getLogger(UserResources.class.getName());

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser() {
        System.out.println("Get users");
        return new User();
    }

    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(User u) {
    	System.out.println("Add user : " + u.getName());
    }

    @PUT
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User u) {
        System.out.println("Update user : " + u.getId());
    }

}
