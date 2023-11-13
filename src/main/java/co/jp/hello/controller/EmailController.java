package co.jp.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.jp.hello.entity.Emaildetails;
import co.jp.hello.service.EmailService;

@RestController
public class EmailController {
	@Autowired
	private EmailService emailService;

	// Sending a simple Email
	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Emaildetails details) {
		String status = emailService.sendSimpleMail(details);

		return status;
	}

	// Sending email with attachment
	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody Emaildetails details) {
		String status = emailService.sendMailWithAttachment(details);

		return status;
	}
}
