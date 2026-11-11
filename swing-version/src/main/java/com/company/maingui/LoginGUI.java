/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ProBook
 */
public class LoginGUI extends JFrame implements ActionListener {

    JFrame frame;
    ImageIcon icon, back;
    JButton patient, doctor, patientB, doctorB, backP, backD;
    JLabel patientLogin,doctorLogin, email, password;
    JTextField emailField;
    JPasswordField passwordField;

    public LoginGUI(JFrame previousFrame) {
        icon = new ImageIcon("Images/logo.png");
        back = new ImageIcon("Images/back.png");

        frame = new JFrame("Login");
        frame.setSize(300, 300);
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(193, 255, 114));
        frame.setLayout(null);
        frame.setResizable(false);

        patient = new CustomButton("As A Patient");
        patient.setBounds(70, 70, 160, 40);
        patient.setForeground(Color.BLACK);
        patient.setBackground(Color.WHITE);
        patient.setFocusable(false);
        patient.addActionListener(this);
        doctor = new CustomButton("As A Doctor");
        doctor.setBounds(70, 150, 160, 40);
        doctor.setForeground(Color.BLACK);
        doctor.setBackground(Color.WHITE);
        doctor.setFocusable(false);
        doctor.addActionListener(this);

        backP = new JButton();
        backP.setIcon(back); 
        backP.setBounds(5, 5, 40, 40);
        backP.setOpaque(false); 
        backP.setContentAreaFilled(false); 
        backP.setBorderPainted(false); 
        backP.addActionListener(this);
        
        backD = new JButton();
        backD.setIcon(back); 
        backD.setBounds(5, 5, 40, 40);
        backD.setOpaque(false); 
        backD.setContentAreaFilled(false); 
        backD.setBorderPainted(false); 
        backD.addActionListener(this);

        patientLogin = new JLabel();
        patientLogin.setText("Patient Login");
        patientLogin.setBounds(85, 20, 300, 50);
        patientLogin.setFont(new Font("Arial", Font.BOLD, 18));
        patientLogin.setForeground(Color.BLACK);
        
        doctorLogin = new JLabel();
        doctorLogin.setText("Doctor Login");
        doctorLogin.setBounds(85, 20, 300, 50);
        doctorLogin.setFont(new Font("Arial", Font.BOLD, 18));
        doctorLogin.setForeground(Color.BLACK);

        email = new JLabel();
        email.setText("E-mail:");
        email.setBounds(30, 90, 50, 20);
        email.setForeground(Color.BLACK);
        emailField = new JTextField();
        emailField.setBounds(110, 90, 140, 25);

        password = new JLabel();
        password.setText("Password:");
        password.setBounds(30, 130, 100, 20);
        password.setForeground(Color.BLACK);
        passwordField = new JPasswordField();
        passwordField.setBounds(110, 130, 140, 25);

        patientB = new CustomButton("Login");
        patientB.setBounds(100, 190, 100, 30);
        patientB.setForeground(Color.BLACK);
        patientB.setBackground(Color.WHITE);
        patientB.setFocusable(false);
        patientB.addActionListener(this);
        
        doctorB = new CustomButton("Login");
        doctorB.setBounds(100, 190, 100, 30);
        doctorB.setForeground(Color.BLACK);
        doctorB.setBackground(Color.WHITE);
        doctorB.setFocusable(false);
        doctorB.addActionListener(this);

        frame.add(patient);
        frame.add(doctor);
        frame.setVisible(true);

        // Add WindowListener to perform actions when the frame is closed
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
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
        if (e.getSource() == patient) {
            frame.remove(patient);
            frame.remove(doctor);
            frame.add(patientLogin);
            frame.add(email);
            frame.add(emailField);
            frame.add(password);
            frame.add(passwordField);
            frame.add(patientB);
            frame.add(backP);
            frame.revalidate();
            frame.repaint();
        } else if (e.getSource() == doctor) {
            frame.remove(patient);
            frame.remove(doctor);
            frame.add(doctorLogin);
            frame.add(email);
            frame.add(emailField);
            frame.add(password);
            frame.add(passwordField);
            frame.add(doctorB);
            frame.add(backD);
            frame.revalidate();
            frame.repaint();
        } else if (e.getSource() == backP){
            frame.remove(patientLogin);
            frame.remove(email);
            frame.remove(emailField);
            frame.remove(password);
            frame.remove(passwordField);
            frame.remove(patientB);
            frame.remove(backP);
            frame.add(patient);
            frame.add(doctor);
            frame.revalidate();
            frame.repaint();
        } else if (e.getSource() == backD){
            frame.remove(doctorLogin);
            frame.remove(email);
            frame.remove(emailField);
            frame.remove(password);
            frame.remove(passwordField);
            frame.remove(doctorB);
            frame.remove(backD);
            frame.add(patient);
            frame.add(doctor);
            frame.revalidate();
            frame.repaint();
        } else if(e.getSource() == patientB){
            
        } else if(e.getSource() == doctorB){
            
        }
    }
}
