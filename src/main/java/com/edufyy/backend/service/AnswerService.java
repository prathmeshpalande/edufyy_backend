package com.edufyy.backend.service;

import com.edufyy.backend.model.Answer;
import com.edufyy.backend.model.Question;
import com.edufyy.backend.model.User;
import com.edufyy.backend.repository.AnswerRepository;
import com.edufyy.backend.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class AnswerService implements InitializingBean {

    @Autowired
    AnswerRepository answerRepository;

    public void add(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> findByQuestionKey(String email, String questionKey) {
        return answerRepository.findByQuestionKey(email, questionKey);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        List<Character> correctOptions = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D'));
        List<Double> difficulties = new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0));

        for (int a = 1; a < 5; a++) {
            for (int b = 1; b < 5; b++) {
                for (int c = 1; c < 5; c++) {
                    for (int d = 1; d < 5; d++) {
                        Answer answer = new Answer();
                        answer.setEmail("palande1996@gmail.com");
                        answer.setQuestionKey("" + a + "/" + b + "/" + c);
                        answer.setQuestionNumber(d);
                        answer.setStudentDifficulty(difficulties.get(new Random().nextInt(difficulties.size())));
                        answer.setSurity(difficulties.get(new Random().nextInt(difficulties.size())).intValue());
                        answer.setAnswer(correctOptions.get(new Random().nextInt(correctOptions.size())));

                        answerRepository.save(answer);
                    }
                }
            }
        }
    }

}
