package com.GirrajTechnology.controller;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {

    private final OllamaChatClient client;

    private static final String prompt = "What is dhara 302";

    public AIController(OllamaChatClient client) {
        this.client = client;
    }

    @GetMapping("/prompt")
    public String promptResponse() {
        return client.call(prompt);
    }
}
