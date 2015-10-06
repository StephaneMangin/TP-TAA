package org.istic.taa.jaxrs.resources;

import org.istic.taa.domain.Team;
import org.istic.taa.repository.TeamRepository;

import javax.persistence.EntityManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by stephane on 05/10/15.
 */
@Path("/")
public class TeamResources {

    private static final Logger logger = Logger.getLogger(TeamResources.class.getName());
    private EntityManager em = TeamRepository.getEntityManager();

    @GET
    @Path("/teams/:id")
    @Produces(MediaType.APPLICATION_JSON)
    public Team getTeam(@PathParam("id") Long id) {
        logger.info("Get team : " + id);
        return em.find(Team.class, id);
    }

    @GET
    @Path("/teams")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> getTeam() {
        List<Team> teams = em.createQuery("SELECT t FROM Team t").getResultList();
        logger.info("Get teams");
        return teams;
    }

    @POST
    @Path("/teams")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTeam(Team t) {
    	logger.info("Add team : " + t.getName());
        em.persist(t);
    }

    @PUT
    @Path("/teams")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateTeam(Team t) {
        logger.info("Update team : " + t.getId());
        em.merge(t);
    }

    @DELETE
    @Path("/teams/:id")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteTeam(@PathParam("id") Long id) {
        logger.info("Delete team  with id : " + id);
        Team team = em.find(Team.class, id);
        em.remove(team);
    }

}
