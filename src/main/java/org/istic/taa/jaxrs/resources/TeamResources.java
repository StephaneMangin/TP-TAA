package org.istic.taa.jaxrs.resources;

import org.istic.taa.domain.Team;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by stephane on 05/10/15.
 */
@Path("/")
public class TeamResources {

    private static final Logger logger = Logger.getLogger(TeamResources.class.getName());

    @GET
    @Path("/teams")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Team> getTeam() {
        System.out.println("Get teams");
        return new HashSet<Team>();
    }

    @POST
    @Path("/teams")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTeam(Team t) {
    	System.out.println("Add team : " + t.getName());
    }

    @PUT
    @Path("/teams")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTeam(Team t) {
        System.out.println("Update team : " + t.getId());
    }

}
