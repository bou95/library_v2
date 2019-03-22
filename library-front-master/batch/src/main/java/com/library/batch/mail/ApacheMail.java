package com.library.batch.mail;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;


import entities.Users;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class ApacheMail {
	
	@Value("${batch.mail}") 
	private String mail;
	
	@Value("${batch.password}") 
	private String password;
	
	public void send(Users user) {
		// Create the email message


		  HtmlEmail email = new HtmlEmail();
		  
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(587);
		  email.setAuthenticator(new DefaultAuthenticator(mail, password));
		  email.setSSLOnConnect(true);
		  try {
			  email.addTo(user.getEmail(), user.getFirstName());
			  email.setFrom(mail, "Moi");
			  email.setSubject("Retard emprunt ouvrage");

			  // set the html message
			  
			  String message = "<html>Bonjour "+user.getLastName();
			  message+="<br><br>Vous recevez cet email suite &agrave; un retard constat&eacute;  &agrave; l'emprunt d'un ouvrage effectu&eacute; aupr&egrave;s de notre Biblioth&egrave;que.";
			  message+="<br>Vous pouvez obtenir plus d'informations en vous connectant &agrave; votre espace personnel sur notre site";
			  message+="<br>Merci de restituer l'ouvrage concern&eacute; par ce retard.<br>";
			  message+="<br>Cordialement<br>";

			  email.setHtmlMsg(message);

			  // set the alternative message
			  email.setTextMsg("Your email client does not support HTML messages");

			  // send the email
			  email.send();  
			  System.out.println("Mail has been sent successfully");
		  }
		 catch (EmailException e) {
			// TODO Auto-generated catch block
			 System.out.println("Unable to send an email" + e.getMessage());
		}

	}
	
	

}
