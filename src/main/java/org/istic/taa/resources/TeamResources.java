package org.istic.taa.resources;

import org.istic.taa.aspect.LogAspect;
import org.istic.taa.domain.Team;
import org.istic.taa.domain.User;
import org.istic.taa.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by stephane on 05/10/15.
 */
@RestController
public class TeamResources {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LogAspect logger;

    @RequestMapping(value = "/teams/:id", method = RequestMethod.GET)
    public Team getTeam(@RequestParam("id") Long id) {
        return teamRepository.findOne(id);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public Iterable<Team> getTeam() {
        return teamRepository.findAll();
    }

    @RequestMapping(value = "/teams", method = RequestMethod.POST)
    public void addTeam(Team t) {
        teamRepository.save(t);
    }

    @RequestMapping(value = "/teams", method = RequestMethod.PUT)
    public void updateTeam(Team t) {
        teamRepository.save(t);
    }

    @RequestMapping(value = "/teams/:id", method = RequestMethod.DELETE)
    public void deleteTeam(@PathParam("id") Long id) {
        teamRepository.delete(id);
    }

}
