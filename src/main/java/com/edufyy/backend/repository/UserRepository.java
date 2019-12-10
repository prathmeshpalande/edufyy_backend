package com.edufyy.backend.repository;

import com.edufyy.backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from User where email = ?1 limit 1", nativeQuery = true)
    User findByEmail(String email);
}
