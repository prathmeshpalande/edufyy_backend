package com.edufyy.backend.question.service;

import com.edufyy.backend.auth.model.Session;
import com.edufyy.backend.auth.service.SessionService;
import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.question.model.KeysByLevelRequest;
import com.edufyy.backend.question.model.QuestionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (session == null) {
            response = GeneralResponseObject.getFailureResponse();
            response.setResponseCode(-1);
            response.setResponseMessage("Invalid session, please login again");
            return response;
        }

        String email = session.getEmail();

        List<QuestionKey> questionKeys;
        if (keysByLevelRequest.getQuestionKey().equals("0"))
            questionKeys = questionKeyService.findByEmail(email);
        else {
            questionKeys = questionKeyService.findByKeyAndLength(email, keysByLevelRequest.getQuestionKey(), keysByLevelRequest.getQuestionKey().split("/").length + 1);
        }
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
