package com.mango.meeting.controller;

import com.mango.meeting.service.EmailService;
import com.mango.meeting.service.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class PageController {

    @Autowired
    private GeminiService geminiService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/summarize")
    public String summarize(@RequestParam(required = false) MultipartFile file,
                            @RequestParam(required = false) String transcript,
                            @RequestParam String prompt,
                            Model model) throws IOException {
        String text = "";

        if (file != null && !file.isEmpty()) {
            text = new String(file.getBytes());
        } else if (transcript != null) {
            text = transcript;
        }

        String summary = geminiService.summarize(text, prompt);
        model.addAttribute("summary", summary);
        return "index";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam String to,
                            @RequestParam String summary,
                            Model model) {
        emailService.sendEmail(to, "Meeting Summary", summary);
        model.addAttribute("message", "Email sent successfully to " + to);
        return "index";
    }
}
