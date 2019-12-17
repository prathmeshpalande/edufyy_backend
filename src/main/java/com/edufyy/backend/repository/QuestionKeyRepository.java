package com.edufyy.backend.repository;

import com.edufyy.backend.model.Answer;
import com.edufyy.backend.model.QuestionKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionKeyRepository extends CrudRepository<Answer, Long> {

    @Query(value = "select * from question_key where email = ?1", nativeQuery =  true)
    List<QuestionKey> findByEmail(String email);
}
