package com.mango.meeting.controller;

import com.mango.meeting.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mail")
public class TestEmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/test")
    public String sendTest(@RequestParam String to) {
        emailService.sendEmail(to,"hi","This is a test email from Mango Meeting");
        return "Mail sent successfully to " + to;
    }
}
