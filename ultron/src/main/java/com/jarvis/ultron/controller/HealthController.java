package com.jarvis.ultron.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "Health Check", description = "API for checking the application's health status")
public class HealthController {

    @Operation(summary = "Check API Health", description = "Returns a simple health status.")
    @GetMapping("/health")
    public Map<String, String> health() {
        return Collections.singletonMap("status", "OK");
    }
}