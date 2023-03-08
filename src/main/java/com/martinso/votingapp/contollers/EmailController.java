package com.martinso.votingapp.contollers;

import com.martinso.votingapp.admin.data.model.Admin;
import com.martinso.votingapp.data.dto.EmailResponse;
import com.martinso.votingapp.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService service;

    @Autowired
    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail(@RequestBody Admin recipient) throws MessagingException {
        EmailResponse response = service.sendInvitationEmail(recipient.getEmail());
        return ResponseEntity.ok().body(response);
    }
}
