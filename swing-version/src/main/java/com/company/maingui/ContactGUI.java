/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ProBook
 */
class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text);
    }
}

public class ContactGUI extends JFrame implements ActionListener {

    JFrame supportFrame;
    JButton submitButton;
    JTextField name, email, subject, message;
    JLabel namelabel, emaillabel, subjectlabel, messagelabel, supportImage;
    ImageIcon icon, image;

    public ContactGUI(JFrame previousFrame) {

        icon = new ImageIcon("Images/logo.png");

        supportFrame = new JFrame("Support");
        supportFrame.setSize(400, 400);
        supportFrame.setIconImage(icon.getImage());
        supportFrame.setLocationRelativeTo(null);
        supportFrame.getContentPane().setBackground(new Color(193, 255, 114));
        supportFrame.setLayout(null);
        supportFrame.setResizable(false);

        image = new ImageIcon("Images/support.png");
        supportImage = new JLabel();
        supportImage.setIcon(image);
        supportImage.setBounds(130, 15, image.getIconWidth(), image.getIconHeight());

        namelabel = new JLabel();
        namelabel.setText("Name: ");
        namelabel.setBounds(90, 120, 100, 20);
        name = new JTextField();
        name.setBounds(180, 120, 140, 25);
        emaillabel = new JLabel();
        emaillabel.setText("Email: ");
        emaillabel.setBounds(90, 150, 100, 20);
        email = new JTextField();
        email.setBounds(180, 150, 140, 25);
        subjectlabel = new JLabel();
        subjectlabel.setText("Subject: ");
        subjectlabel.setBounds(90, 180, 100, 20);
        subject = new JTextField();
        subject.setBounds(180, 180, 140, 25);
        messagelabel = new JLabel();
        messagelabel.setText("Message: ");
        messagelabel.setBounds(90, 210, 100, 20);
        message = new JTextField();
        message.setBounds(180, 210, 140, 50);

        submitButton = new CustomButton("Submit");
        submitButton.setBounds(150, 280, 80, 30);
        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        //adding content to Frame;
        supportFrame.add(supportImage);
        supportFrame.add(namelabel);
        supportFrame.add(name);
        supportFrame.add(emaillabel);
        supportFrame.add(email);
        supportFrame.add(subjectlabel);
        supportFrame.add(subject);
        supportFrame.add(messagelabel);
        supportFrame.add(message);
        supportFrame.add(submitButton);
        supportFrame.setVisible(true);

        // Add WindowListener to perform actions when the frame is closed
        supportFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (previousFrame != null) {
                    previousFrame.setVisible(true); // Show the previous frame
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Support contact = new Support();
        String nametext = name.getText();
        String emailtext = email.getText();
        String subjecttext = subject.getText();
        String messagetext = message.getText();

        if (contact.checkName(nametext)) {
            JOptionPane.showMessageDialog(null, "Invalid Name", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (contact.checkEmail(emailtext)) {
            JOptionPane.showMessageDialog(null, "Invalid E-mail", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (contact.checkSubject(subjecttext)) {
            JOptionPane.showMessageDialog(null, "Subject does not Empty!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (contact.checkSubject(messagetext)) {
            JOptionPane.showMessageDialog(null, "Meassage does not Empty!", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            contact.setEmail(emailtext);
            contact.setMessage(messagetext);
            contact.setName(nametext);
            contact.setSubject(subjecttext);
            boolean check = contact.sendEmail();
            if(check){
                JOptionPane.showMessageDialog(null, "We will contaxt you back as soon as possible", "Sent",
                    JOptionPane.PLAIN_MESSAGE);
                supportFrame.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "There is an issue while sending your message", "Error",
                    JOptionPane.PLAIN_MESSAGE);
                supportFrame.dispose();
            }
        }
    }

}
