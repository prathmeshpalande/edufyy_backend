package com.edufyy.backend.service;

import com.edufyy.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeyDisplayService {

    @Autowired
    QuestionKeyService questionKeyService;

    @Autowired
    SessionService sessionService;

    public GeneralResponseObject getKeysByLevel(KeysByLevelRequest keysByLevelRequest) {

        GeneralResponseObject response = GeneralResponseObject.getSuccessResponse();

        Session session = sessionService.findBySessionKey(keysByLevelRequest.getSessionKey());
        String email = session.getEmail();

        List<QuestionKey> questionKeys;
        if (!keysByLevelRequest.getQuestionKey().equals("0"))
            questionKeys = questionKeyService.findByEmailQuestionKey(email, keysByLevelRequest.getQuestionKey());
        else
            questionKeys = questionKeyService.findByLength(email, Integer.parseInt(keysByLevelRequest.getQuestionKey()) + 1);
//        List<QuestionKey> filteredQuestionKeys = filterQuestionKeysByLevel(questionKeys, keysByLevelRequest.getQuestionKey());

        Map<String, List<QuestionKey>> responseData = new HashMap<>();
        responseData.put("questionKeys", questionKeys);

        response.setResponseData(responseData);

        return response;
    }

//    private List<QuestionKey> filterQuestionKeysByLevel(List<QuestionKey> questionKeys, String questionKey) {
//
//        List<QuestionKey> filteredQuestionKeys = new ArrayList<>();
//        for (QuestionKey questionKey : questionKeys)
//            if (questionKey.getQuestionKey().split(".").length == questionKey)
//                filteredQuestionKeys.add(questionKey);
//
//        return filteredQuestionKeys;
//    }
}
