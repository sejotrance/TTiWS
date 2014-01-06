package ttiws.demo;
	import java.util.*;
	import javax.mail.*;
	import javax.mail.internet.*;
	import javax.activation.*;
	public class MailTest {
	   public static void main(String [] args)
	   {    
	      // Recipient's email ID needs to be mentioned.
	      String to = "sejo1234@gmail.com";

	      // Sender's email ID needs to be mentioned
	      String from = "mail@mailc.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("This is the Subject Line!");

	         // Now set the actual message
	         message.setContent("<h1>Bienvenido a TTi</h1>" +
     				"<p>Se ha generado una contrase�a para que ingreses al Sistema.</p>" +
     				"<p>Usuario: " + "asdas" + "</p>" +
     				"<p>Contrase�a: " + "asdsad "+ "</p>" +
     						"<p><b>NO OLVIDES CAMBIAR TU CONTRASE�A UNA VEZ HAGAS LOGIN</b></p>","text/html");

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	}

