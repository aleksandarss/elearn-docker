package com.acalic.elearndocker.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "heartbeat")
public class HealthCheckResource {
    @GetMapping
    public ResponseEntity<?> getHeartbeat() {
        return ResponseEntity.status(200).build();
    }
}
