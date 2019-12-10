package com.edufyy.backend.repository;

import com.edufyy.backend.model.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {

    @Transactional
    @Modifying
    @Query(value = "update Session set sessionKey = ?1 where email = ?2")
    Integer updateSession(String sessionKey, String email);
}
