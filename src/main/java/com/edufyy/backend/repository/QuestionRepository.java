package com.edufyy.backend.repository;

import com.edufyy.backend.model.Question;
import com.edufyy.backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query(value = "select * from Question where question_key = ?1 and question_number = ?2 limit 1", nativeQuery = true)
    Question findQuestionByAnswer(String questionKey, Integer questionNumber);

    @Query(value = "select * from Question where question_key = ?1 and question_number = ?2 and answer = ?3 limit 1", nativeQuery = true)
    Question findByAnswer(String questionKey, Integer questionNumber, Character answer);

    @Query(value = "select * from Question where question_key = ?1 and (student_difficulty = ?2 or student_difficulty = ?2 - 1 or student_difficulty = ?2 + 1)")
    List<Question> getQuestions(String questionKey, Double proficiency);
}
