package com.edufyy.backend.question.controller;

import com.edufyy.backend.general.model.GeneralResponseObject;
import com.edufyy.backend.question.model.PublishHomeWorkRequest;
import com.edufyy.backend.question.service.HomeWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeWorkController {

    @Autowired
    HomeWorkService homeWorkService;

    @PostMapping("/publish_homework")
    public GeneralResponseObject publishHomeWork(@RequestBody PublishHomeWorkRequest publishHomeWorkRequest) {

        GeneralResponseObject response = homeWorkService.publishHomeWork(publishHomeWorkRequest);

        return response;
    }

    @PostMapping("get_homework")
    public GeneralResponseObject getHomeWork(@RequestBody GetHomeWorkRequest getHomeWorkRequest) {
        GeneralResponseObject response = homeWorkService.getHomeWork(getHomeWorkRequest);

        return response;
    }

}
