package com.GirrajTechnology.config.security;


import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

	@Bean
    public OllamaApi ollamaApi() {
        return new OllamaApi("https://ollama-production-c6ff.up.railway.app/"); // Ensure Ollama is running here
    }

    @Bean
    public OllamaChatClient ollamaChatClient(OllamaApi ollamaApi) {
        return new OllamaChatClient(ollamaApi);
    }




}
