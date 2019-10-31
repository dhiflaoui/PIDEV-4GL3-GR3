package managedbeans;


import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@ManagedBean(name="mail")
@RequestScoped
public class Mail {
private String header;
private String name;
private String mailAddress;
public String getHeader() {
	return header;
}
public void setHeader(String header) {
	this.header = header;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMailAddress() {
	return mailAddress;
}
public void setMailAddress(String mailAddress) {
	this.mailAddress = mailAddress;
}
public void sendMail() {
	final String username = "aminthabti95@gmail.com";
	final String password = "cristiano95";
	Properties properties = new Properties();
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp", "587");
Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}}

		);
try {
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress("aa@aa.com"));
	message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("play_92_92@mail.ru"));
	message.setSubject("Java pi Mail Api");
	message.setText(name+" asks you to join the training named "+ header);
	Transport.send(message);
}catch(MessagingException ex) { throw new RuntimeException(ex);}
}

}
