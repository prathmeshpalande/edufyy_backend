package com.edufyy.backend.auth.repository;

import com.edufyy.backend.auth.model.Session;
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

    @Query(value = "select * from Session where session_key = ?1 limit 1", nativeQuery = true)
    Session findBySessionKey(String sessionKey);
}
