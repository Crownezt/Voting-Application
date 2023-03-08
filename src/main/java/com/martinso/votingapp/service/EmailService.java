package com.martinso.votingapp.service;

import com.martinso.votingapp.data.dto.EmailResponse;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
@AllArgsConstructor
@Service
public class EmailService {
    private final JavaMailSender mailSender;

    @Value("${myapp.app-link}")
    private String myAppLink;

    @Value("${myapp.support-email}")
    private String supportEmail;
    public EmailResponse sendInvitationEmail(String recipient) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(recipient);
        helper.setSubject("Invitation to Voting App as an Administrator");

        String html = "<html><body><h2>Dear Admin,<h2>" +
                "<p> Thank you for requesting to become the Administrator on our voting app!</p>" +
                "<p>You have been invited to use our platform to manage elections and votes.</p>" +
                "<p>Please visit our website and sign in to start using the app: <a href='" + myAppLink + "'>" + myAppLink + "</a></p>" +
                "<p>We are excited to have you join our community of users and look forward to your contributions.</p>" +
                "<p> Please if you have any further questions or need additional assistance, please don't hesitate to reach out to us.</p>" +
                "<p>You can contact us through our support channels or by sending an email to our support team.</p>" +
                "<p>Here's how ypu can contact us <a href='" + supportEmail+ "'><a/>.</p>" +
                "<p> Best regards,</p>" +
                "<p> The Voting App Team</p></body></html>";

        helper.setText(html, true);
        mailSender.send(message);

        return getResponse();
    }

    private EmailResponse getResponse() {
        return EmailResponse.builder()
                .code(HttpStatus.OK.value())
                .isSuccess(true)
                .message("Email sent successfully")
                .build();
    }
}
