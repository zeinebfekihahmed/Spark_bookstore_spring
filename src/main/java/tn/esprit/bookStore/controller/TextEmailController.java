package tn.esprit.bookStore.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.bookStore.entities.EmailTemplate;
import tn.esprit.bookStore.service.EmailService;
import tn.esprit.config.LoggingAspect;

@RestController
public class TextEmailController {
	@Autowired
	private EmailService emailService;
	DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
    //obtenir la date courante
    Date date = new Date();
    String strDate = dFormat.format(date);  
    String date2="2021-02-06";
	
	private static final Logger l = LogManager.getLogger(LoggingAspect.class);
	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public String sendEmail(@RequestBody EmailTemplate emailTemplate) {
		if(strDate.equals(date2)){
		try {
			
			l.info("Sending Simple Text Email....");
			emailService.sendTextEmail(emailTemplate);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
		}else{return "Ce n'est pas une saison de solde";}
	}

}
