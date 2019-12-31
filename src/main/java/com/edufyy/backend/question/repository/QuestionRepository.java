package com.edufyy.backend.question.repository;

import com.edufyy.backend.question.model.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query(value = "select * from Question where email = ?3 and question_key = ?1 and question_number = ?2 limit 1", nativeQuery = true)
    Question findQuestionByUniqueIdentification(String questionKey, Integer questionNumber, String email);

    @Query(value = "select * from Question where email = ?4 and question_key = ?1 and question_number = ?2 and correct_option = ?3 limit 1", nativeQuery = true)
    Question findByAnswer(String questionKey, Integer questionNumber, Character answer, String email);

    @Query(value = "select * from Question where email = ?3 and question_key LIKE ?1% and (developer_difficulty >= ?2 - 1 and developer_difficulty <= ?2 + 1)", nativeQuery = true)
    List<Question> getQuestions(String questionKey, Double proficiency, String email);
}
