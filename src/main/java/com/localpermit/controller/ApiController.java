package com.localpermit.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    private static final Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/welcome")
    public Map<String, String> welcome(HttpServletRequest request) {
        logger.info("Request received: {} {}", request.getMethod(), request.getRequestURI());
        return Map.of("message", "Welcome to the Spring Boot API Service!");
    }
}
