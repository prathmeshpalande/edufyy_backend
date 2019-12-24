package com.edufyy.backend.question.service;

import com.edufyy.backend.question.model.QuestionKey;
import com.edufyy.backend.question.repository.QuestionKeyRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionKeyService implements InitializingBean {

    @Autowired
    QuestionKeyRepository questionKeyRepository;

    public List<QuestionKey> findByEmail(String email) {
        return questionKeyRepository.findByEmail(email);
    }

    public List<QuestionKey> findByKeyAndLength(String email, String questionKey, Integer length) {
        return questionKeyRepository.findByKeyAndLength(email, questionKey, length);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int a = 1; a < 5; a++) {
            QuestionKey questionKey = new QuestionKey();
            questionKey.setEmail("palande1996@gmail.com");
            questionKey.setQuestionKey("" + a);
            questionKey.setName("Question Key " + a);

            questionKeyRepository.save(questionKey);

            for (int b = 1; b < 5; b++) {
                QuestionKey questionKey1 = new QuestionKey();
                questionKey1.setEmail("palande1996@gmail.com");
                questionKey1.setQuestionKey("" + a + "/" + b);
                questionKey1.setName("Question Key " + a + "/" + b);

                questionKeyRepository.save(questionKey1);

                for (int c = 1; c < 5; c++) {
                    QuestionKey questionKey2 = new QuestionKey();
                    questionKey2.setEmail("palande1996@gmail.com");
                    questionKey2.setQuestionKey("" + a + "/" + b + "/" + c);
                    questionKey2.setName("Question Key " + a + "/" + b + "/" + c);

                    questionKeyRepository.save(questionKey2);
                }
            }
        }
    }
}
