package co.jp.hello.service;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import co.jp.hello.entity.Emaildetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;
	@Override
	public String sendSimpleMail(Emaildetails details) {
		// Try block to check for exceptions
		// try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo("ayemyawai555@gmail.com");
			mailMessage.setText("DSF");
			mailMessage.setSubject("sdfjlk");

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
			// }

		// Catch block to handle the exceptions
			// catch (Exception e) {
			// return "Error while Sending Mail";
			// }
	}

	@Override
	public String sendMailWithAttachment(Emaildetails details) {
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());

			// Adding the attachment
			FileSystemResource file = new FileSystemResource(new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);

			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}
}
