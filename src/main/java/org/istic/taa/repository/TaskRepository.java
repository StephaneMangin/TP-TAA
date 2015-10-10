package org.istic.taa.repository;

import org.istic.taa.domain.Task;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by stephane on 06/10/15.
 */
public interface TaskRepository extends CrudRepository<Task, Long> {
}
