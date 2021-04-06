package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailServiceImp implements EmailService {
	 @Autowired
	    private JavaMailSender emailSender;

	    public void sendSimpleMessage( String to, String subject, String text) {
	     
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("apidariimmobilier@gmail.com");
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	    }

}
