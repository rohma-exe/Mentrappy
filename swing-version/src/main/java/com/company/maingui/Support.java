/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;

/**
 *
 * @author ProBook
 */
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 *
 * @author ProBook
 */
public class Support {

    final String to;
    final String from;
    private String subject;
    private String name;
    private String email;
    private String message;

    Support() {
        to = System.getenv().getOrDefault("MENTRAPPY_SUPPORT_RECIPIENT", "");
        from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", "");
        subject = "";
        name = "";
        email = "";
        message = "";
    }

    Support(String n, String e, String s, String m) {
        to = System.getenv().getOrDefault("MENTRAPPY_SUPPORT_RECIPIENT", "");
        from = System.getenv().getOrDefault("MENTRAPPY_GMAIL_USERNAME", "");
        subject = s;
        name = n;
        email = e;
        message = m;
    }

    String getName() {
        return name;
    }

    void setName(String n) {
        if (!checkName(n)) {
            name = n;
        }
    }

    String getEmail() {
        return email;
    }

    void setEmail(String e) {
        if (!checkEmail(e)) {
            email = e;
        }
    }

    String getSubject() {
        return subject;
    }

    void setSubject(String s) {
        if (!checkSubject(s)) {
            subject = s;
        }
    }

    String getMessage() {
        return message;
    }

    void setMessage(String m) {
        if (!checkSubject(m)) {
            message = m;
        }
    }

    boolean checkEmail(String email) {
        boolean check = true;
        if (!email.trim().isEmpty() && email.contains("@") && email.endsWith(".com") && !email.contains(" ")) {
            check = false;
        }
        return check;
    }

    boolean checkSubject(String subject) {
        boolean check = true;
        if (!subject.trim().isEmpty()) {
            check = false;
        }
        return check;
    }

    boolean checkName(String name) {
        boolean alphacheck;
        boolean check = true;
        if (name.trim().isEmpty()) {
            check = true;
        } else {
            name = name.trim();
            name = name.replace(" ", "");
            alphacheck = name.matches("[a-zA-Z]+");
            if (alphacheck) {
                check = false;
            }
        }
        return check;
    }

    boolean sendEmail() {
        boolean tick = false;
        String text = name + "\n" + email + "\n" + message;
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
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        //Message
        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(username));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            tick = true;

        } catch (MessagingException e) {
            System.out.println(e);
        }
        return tick;
    }

    boolean sendEmail(String to, String from, String s, String m) {
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
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        //Message
        try {
            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(username));
            message.setSubject(s);
            message.setText(m);
            Transport.send(message);
            tick = true;

        } catch (MessagingException e) {
            System.out.println(e);
        }
        return tick;
    }
}



