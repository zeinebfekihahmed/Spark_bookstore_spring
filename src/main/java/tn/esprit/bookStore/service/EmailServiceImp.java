package tn.esprit.bookStore.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.bookStore.entities.EmailTemplate;

@Service
public class EmailServiceImp implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${email.address}")
	private String attchEmailAddr;
	

	@Override
	public void sendTextEmail(EmailTemplate emailTemplate) {
		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			
			if (emailTemplate.getSendTo().contains(",")) {
				String[] emails = emailTemplate.getSendTo().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {

					msg.setTo(emails[i]);
					msg.setSubject(emailTemplate.getSubject());
					msg.setText(emailTemplate.getBody());
                    javaMailSender.send(msg);	
}

			} else {
				msg.setTo(emailTemplate.getSendTo());
				msg.setSubject(emailTemplate.getSubject());
				msg.setText(emailTemplate.getBody());
				javaMailSender.send(msg);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	

}
