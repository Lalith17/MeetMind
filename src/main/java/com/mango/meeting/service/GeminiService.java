package com.mango.meeting.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class GeminiService {

    private final Client client;

    public GeminiService(@Value("${google.api.key}") String apiKey) {
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalArgumentException("Google API Key is missing! Please set GOOGLE_API_KEY environment variable.");
        }
        this.client = Client.builder()
                .apiKey(apiKey)
                .build();
    }

    public String summarize(String transcript, String prompt) {
        String fullPrompt = "Transcript:\n" + transcript + "\nInstruction: " + prompt;


        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-2.5-flash",
                        fullPrompt,
                        null);
        return response.text();
    }
}
