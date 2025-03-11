package com.GirrajTechnology.config.security;


import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

	@Bean
    public OllamaApi ollamaApi() {
        return new OllamaApi("http://localhost:11434"); // Ensure Ollama is running here
    }

    @Bean
    public OllamaChatClient ollamaChatClient(OllamaApi ollamaApi) {
        return new OllamaChatClient(ollamaApi);
    }




}
