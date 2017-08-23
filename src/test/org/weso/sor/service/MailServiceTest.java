package org.weso.sor.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.test.context.ContextConfiguration;
import org.weso.sor.domain.AbstractSorJUnit38SpringContextTests;

@ContextConfiguration(locations = {
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContextDao.xml",
		"file:///C:/Development/webProjects/weso/WebContent/WEB-INF/ApplicationContext.xml" })
public class MailServiceTest extends AbstractSorJUnit38SpringContextTests {

	public void xtestFindMailService() {
		MailService ms = (MailService) applicationContext
				.getBean("mailService");
		assertNotNull(ms);
	}

	public void xtestSend() throws Exception {
		String from = "brian.forester@gmail.com";
		String to = "brian.forester@gmail.com";

		String host = "smtp.gmail.com:465";
		String username = "louise.tamres";
		String password = "usabda94";
		Properties props = new Properties();
		props.put("mail.smtps.auth", "true");
		// "ToLearnANew"
		// Setup mail server
		props.put("mail.smtp.host", host);

		// Get session
		Session session = Session.getDefaultInstance(props, null);

		// Define message
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("Hello JavaMail");
		message.setText("Welcome to JavaMail");

		// Send message
		Transport.send(message);

		// set the message content here
		Transport t = session.getTransport("smtps");
		try {
			t.connect(host, username, password);
			t.sendMessage(message, message.getAllRecipients());
		} finally {
			t.close();
		}
	}

	public void testSend2() throws Exception {
		String from = "bdf@tamres.com";
		String to = "brian.forester@gmail.com";
		String host = "mail.tamres.com";
		String username = "bdf@tamres.com";
		String password = "hammer668923";

		Properties props = new Properties();
		// Properties props=System.getProperties();
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "110");
		props.put("mail.smtp.starttls.enable", Boolean.FALSE);
		props.put("mail.smtp.auth", Boolean.TRUE);
		props.put("mail.smtp.debug", "true");
//	    props.put("mail.smtp.socketFactory.port", new Integer(465));
	     
		Session session = Session.getInstance( props,new
				SMTPAuthenticator(props));

//		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		MimeMessage msg = new MimeMessage(session);
		msg.setText("From Java Mail");
		msg.setSubject("Subject of Java Mail");
		msg.setFrom(new InternetAddress("brian.forester@gmail.com"));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress("brian.forester@gmail.com"));
//		msg.addRecipient(Message.RecipientType.CC, new InternetAddress("lakewoodweso@gmail.com"));
		msg.saveChanges();
		Transport transport = session.getTransport("smtp");
		//transport.connect(host, username, password);
		transport.connect();
		transport.sendMessage(msg, msg.getAllRecipients());
		transport.close();
	}
	
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		private String user;
		private String pass;

		SMTPAuthenticator (Properties properties){
		this.user = properties.getProperty("bdf@tamres.com");
		this.pass = properties.getProperty("hammer668923");
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.user,this.pass);
		}
	}
}
