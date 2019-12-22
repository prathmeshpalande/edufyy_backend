package com.edufyy.backend.service;

import com.edufyy.backend.model.Answer;
import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.Duration;
import java.time.Instant;

@Service
public class ProficiencyService {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    public GeneralResponseObject getProficiency(String email, String questionKey) {

        Instant start = Instant.now();

        List<Answer> answers = answerService.findByQuestionKey(email, questionKey);

        // Map difficulty to answers
        Map<Double, List<Answer>> mapDifficultyToAnswers = mapDifficultyToAnswers(answers);
        // Count total answers
        int totalAnswers = answers.size();

        // Find sub-proficiency per question difficulty
        List<Double> subProficiency = new ArrayList<>();
        for (Map.Entry<Double, List<Answer>> difficultyToAnswerEntry : mapDifficultyToAnswers.entrySet()) {
            Integer totalRight = 0;
            for (Answer answer : difficultyToAnswerEntry.getValue())
                if (questionService.findByAnswer(answer.getQuestionKey(), answer.getQuestionNumber(), answer.getAnswer()) != null)
                    totalRight += 1;

            subProficiency.add(difficultyToAnswerEntry.getKey() * totalRight / ((double) totalAnswers / 2) * 0.75);
        }
        // Sum proficiencies for key
        Double proficiency = subProficiency.stream().mapToDouble(Double::doubleValue).sum();

        // Construct response
        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        Map<String, Double> responseData = new HashMap<>();
        responseData.put("proficiency", proficiency);
        response.setResponseData(responseData);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("PROFICIENCY CALCULATION: Time taken: "+ timeElapsed.toMillis() +" milliseconds");
        return response;
    }

    public Map<Double, List<Answer>> mapDifficultyToAnswers(List<Answer> answers) {
        Map<Double, List<Answer>> mapDifficultyToAnswers = new HashMap<>();

        for (Answer answer : answers) {
            Question question = questionService.findQuestionByAnswer(answer.getQuestionKey(), answer.getQuestionNumber());
            Double answerDifficulty = question.getStudentDifficulty();
            List<Answer> tempAnswers;
            if (mapDifficultyToAnswers.get(answerDifficulty) == null)
                tempAnswers = new ArrayList<>();
            else
                tempAnswers = mapDifficultyToAnswers.get(answerDifficulty);
            tempAnswers.add(answer);
            mapDifficultyToAnswers.put(answerDifficulty, tempAnswers);
        }

        return mapDifficultyToAnswers;
    }

}
