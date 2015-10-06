package org.istic.taa.repository;

import org.istic.taa.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by stephane on 06/10/15.
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
