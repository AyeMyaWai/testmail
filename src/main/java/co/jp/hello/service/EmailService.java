package co.jp.hello.service;

import co.jp.hello.entity.Emaildetails;
public interface EmailService {

	// Method
	// To send a simple email
	String sendSimpleMail(Emaildetails details);

	// Method
	// To send an email with attachment
	String sendMailWithAttachment(Emaildetails details);

}
