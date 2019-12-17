package com.edufyy.backend.controller;

import com.edufyy.backend.model.GeneralResponseObject;
import com.edufyy.backend.model.KeysByLevelRequest;
import com.edufyy.backend.service.KeyDisplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeyDisplayController {

    @Autowired
    KeyDisplayService keyDisplayService;

    @PostMapping("/get_keys_by_level")
    public GeneralResponseObject getKeysByLevel(@RequestBody KeysByLevelRequest keysByLevelRequest) {

        GeneralResponseObject response = keyDisplayService.getKeysByLevel(keysByLevelRequest);

        return response;
    }
}
