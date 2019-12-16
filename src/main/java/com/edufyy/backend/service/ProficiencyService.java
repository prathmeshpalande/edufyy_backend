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

@Service
public class ProficiencyService {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    public GeneralResponseObject getProficiency(String email, String questionKey) {

        List<Answer> answers = answerService.findByQuestionKey(email, questionKey);

        // TODO: Proficiency Calculation Logic
        // Map difficulty to answers
        Map<Integer, List<Answer>> mapDifficultyToAnswers = mapDifficultyToAnswers(answers);
        // Count total answers
        Integer totalAnswers = answers.size();

        // TODO: Find individual proficiency and calculate key proficiency
        // Find subproficiency per question difficulty
        List<Double> subProficiency = new ArrayList<>();
        for (Map.Entry<Integer, List<Answer>> difficultyToAnswerEntry : mapDifficultyToAnswers.entrySet()) {
            Integer totalRight = 0;
            for (Answer answer : difficultyToAnswerEntry.getValue())
                if (questionService.findByAnswer(answer.getQuestionKey(), answer.getQuestionNumber(), answer.getAnswer()) != null)
                    totalRight += 1;

            subProficiency.add((double) difficultyToAnswerEntry.getKey() * totalRight / ((double) totalAnswers / 2) * 0.75);
        }
        // Sum prificiencies for key
        Double proficiency = subProficiency.stream().mapToDouble(Double::doubleValue).sum();

        // Construct response
        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();
        Map<String, Double> responseData = new HashMap<>();
        responseData.put("proficiency", proficiency);
        response.setResponseData(responseData);

        return response;
    }

    public Map<Integer, List<Answer>> mapDifficultyToAnswers(List<Answer> answers) {
        Map<Integer, List<Answer>> mapDifficultyToAnswers = new HashMap<>();

        for (Answer answer : answers) {
            Question question = questionService.findQuestionByAnswer(answer.getQuestionKey(), answer.getQuestionNumber());
            Integer answerDifficulty = question.getStudentDiffuculty();
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
