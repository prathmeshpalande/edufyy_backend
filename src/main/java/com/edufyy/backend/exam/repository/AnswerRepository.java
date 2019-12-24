package com.edufyy.backend.exam.repository;

import com.edufyy.backend.exam.model.Answer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    @Query(value = "select * from Answer where email = ?1 and question_key LIKE ?2%", nativeQuery = true)
    List<Answer> findByQuestionKey(String email, String questionKey);

}
