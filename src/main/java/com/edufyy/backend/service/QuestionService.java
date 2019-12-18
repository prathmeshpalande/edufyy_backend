package com.edufyy.backend.service;

import com.edufyy.backend.model.Question;
import com.edufyy.backend.repository.QuestionRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class QuestionService implements InitializingBean {

    @Autowired
    QuestionRepository questionRepository;

    public Question findQuestionByAnswer(String questionKey, Integer questionNumber) {
        return questionRepository.findQuestionByAnswer(questionKey, questionNumber);
    }

    public Question findByAnswer(String questionKey, Integer questionNumber, Character answer) {
        return questionRepository.findByAnswer(questionKey, questionNumber, answer);
    }

    public List<Question> getQuestions(String questionKey, Double proficiency) {
        return questionRepository.getQuestions(questionKey, proficiency);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Character> correctOptions = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));
        List<Double> difficulties = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        for (int a = 1; a < 5; a++) {
            for (int b = 1; b < 5; b++) {
                for (int c = 1; c < 5; c++) {
                    for (int d = 1; d < 5; d++) {
                        Question question = new Question();
                        question.setQuestionKey("" + a + "." + b + "." + c);
                        question.setQuestionNumber(d);
                        question.setQuestion("Question " + d);
                        question.setOptionA("Option A");
                        question.setOptionB("Option B");
                        question.setOptionC("Option C");
                        question.setOptionD("Option D");
                        question.setCorrectOption(correctOptions.get(new Random().nextInt(correctOptions.size())));
                        question.setDeveloperDifficulty(difficulties.get(new Random().nextInt(difficulties.size())));
                        question.setStudentDiffuculty(difficulties.get(new Random().nextInt(difficulties.size())));
                        question.setPremium(true);

                        questionRepository.save(question);
                    }
                }
            }
        }
    }
}
