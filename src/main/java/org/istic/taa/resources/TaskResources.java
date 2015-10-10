package org.istic.taa.resources;

import org.istic.taa.domain.Task;
import org.istic.taa.repository.TaskRepository;
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
public class TaskResources {

    @Autowired
    private TaskRepository taskRepository;

    private static final Logger logger = Logger.getLogger(TaskResources.class.getName());

    @RequestMapping(value = "/tasks/:id", method = RequestMethod.GET)
    public Task getTask(@RequestParam("id") Long id) {
        logger.info("Get task : " + id);
        return taskRepository.findOne(id);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public Iterable<Task> getTask() {
        logger.info("Get tasks");
        return taskRepository.findAll();
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public void addTask(Task u) {
        logger.info("Add task : " + u.getName());
        taskRepository.save(u);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public void updateTask(Task u) {
        logger.info("Update task : " + u.getId());
        taskRepository.save(u);
    }

    @RequestMapping(value = "/tasks/:id", method = RequestMethod.DELETE)
    public void deleteTask(@PathParam("id") Long id) {
        logger.info("Delete task  with id : " + id);
        taskRepository.delete(id);
    }

}

