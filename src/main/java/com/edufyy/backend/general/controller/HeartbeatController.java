package com.edufyy.backend.general.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartbeatController {

    @GetMapping("/heartbeat")
    public Boolean getHeartbeat() {
        return true;
    }

}
