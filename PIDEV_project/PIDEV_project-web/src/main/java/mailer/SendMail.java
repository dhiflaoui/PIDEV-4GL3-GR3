package mailer;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.Mail;

public class SendMail {

	private static final String SMTP_SERVER = "smtp.gmail.com";
	private static final String USERNAME = "yousfi.iheb@esprit.tn";
	private static final String PASSWORD = "07206251";
	static final int PORT = 587;

	public static void send(Mail mail) {

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", SMTP_SERVER);
		props.put("mail.smtp.user", USERNAME);
		props.put("mail.smtp.password", PASSWORD);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		String[] to = { mail.getDestinataire() };

		Session session = Session.getDefaultInstance(props, null);
		MimeMessage message = new MimeMessage(session);
		try {

			message.setFrom(new InternetAddress(USERNAME));

			InternetAddress[] toAddress = new InternetAddress[to.length];

			for (int i = 0; i < to.length; i++)
				toAddress[i] = new InternetAddress(to[i]);

			for (int i = 0; i < toAddress.length; i++)

				message.addRecipient(Message.RecipientType.TO, toAddress[i]);

			message.setSubject(mail.getObjet());
			message.setText(mail.getContent());
			Transport transport;
			transport = session.getTransport("smtp");
			transport.connect(SMTP_SERVER, USERNAME, PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (NoSuchProviderException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
