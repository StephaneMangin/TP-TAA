package org.istic.taa.resources;

import org.istic.taa.domain.Team;
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
public class TeamResources {

    private static final Logger logger = Logger.getLogger(TeamResources.class.getName());

    @RequestMapping(value = "/teams/:id", method = RequestMethod.GET)
    public Team getTeam(@RequestParam("id") Long id) {
        logger.info("Get team : " + id);
        return new Team();
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public List<Team> getTeam() {
        logger.info("Get teams");
        return new ArrayList<Team>();
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public void addTeam(Team t) {
    	logger.info("Add team : " + t.getName());
    }

    @RequestMapping(value = "/teams", method = RequestMethod.PUT)
    public void updateTeam(Team t) {
        logger.info("Update team : " + t.getId());
    }

    @RequestMapping(value = "/teams", method = RequestMethod.DELETE)
    public void deleteTeam(@PathParam("id") Long id) {
        logger.info("Delete team  with id : " + id);
    }

}
