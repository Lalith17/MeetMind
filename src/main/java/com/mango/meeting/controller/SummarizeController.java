package com.mango.meeting.controller;

import com.mango.meeting.service.GeminiService;
import com.mango.meeting.dto.SummarizeRequest;
import com.mango.meeting.dto.SummarizeResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SummarizeController {
    private final GeminiService geminiService;

    public SummarizeController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/summarize")
    public SummarizeResponse summarize(@RequestBody SummarizeRequest request) {
        String summary = geminiService.summarize(request.getTranscript(), request.getPrompt());
        return new SummarizeResponse(summary);
    }

    @PostMapping("/upload")
    public String uploadTranscript(@RequestParam("file") MultipartFile file) throws IOException {
        return new String(file.getBytes());
    }

}
