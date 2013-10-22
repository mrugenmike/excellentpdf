package com.ee.excellentpdf.email;

import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Map;
import java.util.Properties;

@Component
public class GmailEmailService implements EmailService {

      private String username;
      private String password;


     Properties props ;
     MyPasswordAuthenticator passwordAuthenticator;

    public GmailEmailService(){
        this.username = "excellentpdf@gmail.com";
        this.password = "pdfuser@123";
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        passwordAuthenticator=new MyPasswordAuthenticator(username,password);
    }


    public boolean sendMail(File attachment, String emailId, String subject, String body) {
        final Session session = Session.getInstance(props,passwordAuthenticator);

        try {
            final Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailId));
            message.setSubject(subject);
            //message.setText(body);
            final Multipart multipart = new MimeMultipart();

            final MimeBodyPart messageBodyPart = new MimeBodyPart();
            String fileName = attachment.getName();
            DataSource source = new FileDataSource(attachment);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);
        } catch (MessagingException e) {
            return false;
        }
        return true;
    }

    public void sendEmailToAll(Map<String, String> emailAndFiles, String emailBody, String emailSubject) {
        for (String email: emailAndFiles.keySet()){
            sendMail(new File(emailAndFiles.get(email)), email, emailSubject, emailBody);
        }
    }
}

class MyPasswordAuthenticator extends Authenticator {
    private String username;
    private String password;

    public MyPasswordAuthenticator(String username,String password){
        this.username = username;
        this.password = password;
    }

    @Override
     public javax.mail.PasswordAuthentication getPasswordAuthentication(){
           return  new javax.mail.PasswordAuthentication(username,password);
    }

}
