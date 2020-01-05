package com.edufyy.backend.question.service;

import com.edufyy.backend.auth.model.Session;
import com.edufyy.backend.auth.service.SessionService;
import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.question.model.KeysByLevelRequest;
import com.edufyy.backend.question.model.QuestionKey;
import com.edufyy.backend.question.model.QuestionKeyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.util.ArrayUtil;

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
//        List<QuestionKey> filteredQuestionKeys = filterQuestionKeysByLevel(questionKeys, keysByLevelRequest.getSectionKey());

        List<QuestionKeyResponse> questionKeyResponses = nestKeys(questionKeys);

        Map<String, List<QuestionKeyResponse>> responseData = new HashMap<>();
        responseData.put("questionKeys", questionKeyResponses);

        response.setResponseData(responseData);

        return response;
    }

    private List<QuestionKeyResponse> nestKeys(List<QuestionKey> questionKeys) {
        Map<String, QuestionKeyResponse> mapQuestionKeyResponses = new HashMap<>();

        List<QuestionKeyResponse> listQuestionKeyResponse = new ArrayList<>();

        Integer baseLength = questionKeys.get(0).getQuestionKey().split("/").length;

        for (QuestionKey questionKey : questionKeys) {

            String[] keyQuestionKeySplit = questionKey.getQuestionKey().split("/");

            QuestionKeyResponse questionKeyResponse = new QuestionKeyResponse();
            questionKeyResponse.setId(questionKey.getId());
            questionKeyResponse.setName(questionKey.getName());
            questionKeyResponse.setEmail(questionKey.getEmail());
            questionKeyResponse.setQuestionKey(questionKey.getQuestionKey());
            questionKeyResponse.setQuestionKeys(new ArrayList<>());

            if (keyQuestionKeySplit.length != baseLength) {
                Integer lastIndexOfSeparator = questionKey.getQuestionKey().lastIndexOf('/');
                QuestionKeyResponse innerQuestionKeyResponse = mapQuestionKeyResponses.get(questionKey.getQuestionKey().substring(0, lastIndexOfSeparator));
                List<QuestionKeyResponse> questionKeyResponses = innerQuestionKeyResponse.getQuestionKeys();
                questionKeyResponses.add(questionKeyResponse);
            }
            mapQuestionKeyResponses.put(questionKey.getQuestionKey(), questionKeyResponse);

        }

        for (Map.Entry<String, QuestionKeyResponse> entry : mapQuestionKeyResponses.entrySet())
            if (entry.getKey().split("/").length == baseLength)
                listQuestionKeyResponse.add(entry.getValue());

        return listQuestionKeyResponse;
    }

//    private List<QuestionKey> filterQuestionKeysByLevel(List<QuestionKey> questionKeys, String questionKey) {
//
//        List<QuestionKey> filteredQuestionKeys = new ArrayList<>();
//        for (QuestionKey questionKey : questionKeys)
//            if (questionKey.getSectionKey().split(".").length == questionKey)
//                filteredQuestionKeys.add(questionKey);
//
//        return filteredQuestionKeys;
//    }
}
