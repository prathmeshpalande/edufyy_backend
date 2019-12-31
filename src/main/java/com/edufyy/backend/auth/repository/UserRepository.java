package com.edufyy.backend.auth.repository;

import com.edufyy.backend.auth.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select * from User where email = ?1 limit 1", nativeQuery = true)
    User findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "update User set password = ?2 where email = ?1")
    Integer updatePassword(String email, String password);
}
