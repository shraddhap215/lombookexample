package bookLombok.util;

import bookLombok.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.SimpleMailMessage;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private JavaMailSender mailSender;;
    @Autowired
    BookRepository bookRepo;
    public void sendMail(String toEmail, String subject, String body){
        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("shraddhapatil15278@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);
        mailSender.send(message);
    }

}
