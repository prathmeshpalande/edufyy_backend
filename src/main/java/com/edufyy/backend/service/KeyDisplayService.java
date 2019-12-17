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

        List<QuestionKey> questionKeys = questionKeyService.findByEmail(email);

        List<QuestionKey> filteredQuestionKeys = filterQuestionKeysByLevel(questionKeys, keysByLevelRequest.getLevel());

        Map<String, List<QuestionKey>> responseData = new HashMap<>();
        responseData.put("questionKeys", filteredQuestionKeys);

        response.setResponseData(responseData);

        return response;
    }

    private List<QuestionKey> filterQuestionKeysByLevel(List<QuestionKey> questionKeys, Integer level) {

        List<QuestionKey> filteredQuestionKeys = new ArrayList<>();
        for (QuestionKey questionKey : questionKeys)
            if (questionKey.getQuestionKey().split(".").length == level)
                filteredQuestionKeys.add(questionKey);

        return filteredQuestionKeys;
    }
}
