package tn.esprit.bookStore.service;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.bookStore.entities.EmailTemplate;

public interface EmailService {
	void sendTextEmail(EmailTemplate emailTemplate);

}
