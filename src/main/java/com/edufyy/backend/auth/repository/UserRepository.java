package com.edufyy.backend.auth.repository;

import com.edufyy.backend.auth.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from User where email = ?1 limit 1", nativeQuery = true)
    User findByEmail(String email);
}
