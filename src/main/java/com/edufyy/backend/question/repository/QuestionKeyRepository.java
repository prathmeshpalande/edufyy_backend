package com.edufyy.backend.question.repository;

import com.edufyy.backend.question.model.QuestionKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionKeyRepository extends CrudRepository<QuestionKey, Long> {

    @Query(value = "select * from question_key where email = ?1 order by question_key", nativeQuery =  true)
    List<QuestionKey> findByEmail(String email);

    // TODO: Usage of length pending
    @Query(value = "select * from question_key where email = ?1 and question_key like ?2% order by question_key", nativeQuery = true)
    List<QuestionKey> findByKeyAndLength(String email, String questionKey, Integer length);
}
