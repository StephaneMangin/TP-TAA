package org.istic.taa.resources;

import org.istic.taa.aspect.LogAspect;
import org.istic.taa.domain.Sprint;
import org.istic.taa.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.PathParam;
import java.util.logging.Logger;

/**
 * Created by stephane on 05/10/15.
 */
@RestController
public class SprintResources {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private LogAspect logger;

    @RequestMapping(value = "/sprints/:id", method = RequestMethod.GET)
    public Sprint getSprint(@RequestParam("id") Long id) {
        return sprintRepository.findOne(id);
    }

    @RequestMapping(value = "/sprints", method = RequestMethod.GET)
    public Iterable<Sprint> getSprint() {
        return sprintRepository.findAll();
    }

    @RequestMapping(value = "/sprints", method = RequestMethod.POST)
    public void addSprint(Sprint u) {
        sprintRepository.save(u);
    }

    @RequestMapping(value = "/sprints", method = RequestMethod.PUT)
    public void updateSprint(Sprint u) {
        sprintRepository.save(u);
    }

    @RequestMapping(value = "/sprints/:id", method = RequestMethod.DELETE)
    public void deleteSprint(@PathParam("id") Long id) {
        sprintRepository.delete(id);
    }

}

