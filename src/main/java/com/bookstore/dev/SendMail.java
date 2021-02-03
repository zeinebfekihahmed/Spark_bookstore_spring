package com.bookstore.dev;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendMail {
	@Autowired
    private JavaMailSender javaMailSender;
 
    public 	void sendEmail(String emailTo,String subject,String text) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(emailTo);

        msg.setSubject(subject);
        msg.setText(text);

        javaMailSender.send(msg);

    }
}
