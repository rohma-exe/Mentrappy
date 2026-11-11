/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Email;

/**
 *
 * @author ProBook
 */
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.*;
public class GmailSender 
{
    public boolean sendEmail(String to, String from, String subject, String text)
    {
        boolean tick = false; 
        //smtp Properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        // Load SMTP credentials from environment variables; never commit secrets.
        String username = System.getenv("MENTRAPPY_GMAIL_USERNAME");
        String password = System.getenv("MENTRAPPY_GMAIL_APP_PASSWORD");
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            System.err.println("Email is not configured. Set MENTRAPPY_GMAIL_USERNAME and MENTRAPPY_GMAIL_APP_PASSWORD.");
            return false;
        }
        
        //Session
        Session session = Session.getInstance(props, new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username, password);
            }
        });
        
        //Message
        try
        {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            tick = true;
            
        }
        catch(MessagingException e)
        {
        }
        return tick;
    }
    public boolean sendEmail(String to, String from, String num)
    {
        boolean tick = false; 
        //smtp Properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        // Load SMTP credentials from environment variables; never commit secrets.
        String username = System.getenv("MENTRAPPY_GMAIL_USERNAME");
        String password = System.getenv("MENTRAPPY_GMAIL_APP_PASSWORD");
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            System.err.println("Email is not configured. Set MENTRAPPY_GMAIL_USERNAME and MENTRAPPY_GMAIL_APP_PASSWORD.");
            return false;
        }
        
        //Session
        Session session = Session.getInstance(props, new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(username, password);
            }
        });
        
        //Message
        try
        {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject("Verification Code");
            message.setText(num);
            Transport.send(message);
            tick = true;
            
        }
        catch(MessagingException e)
        {
        }
        return tick;
    }
}