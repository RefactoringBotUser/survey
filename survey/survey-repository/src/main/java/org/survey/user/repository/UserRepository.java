package org.survey.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.survey.user.model.User;

/**
 * UserRepository reads and writes Users to database. Uses Spring-JPA and
 * CrudRepository to create a UserRepositoryImpl which contains CRUD methods for
 * reading and writing users to database. See
 * /user-repository/src/test/resources/spring-config-database.xml for Spring
 * configuration.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(@Param("email") String email);
    User findByUsername(@Param("username") String username);
}