/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ProBook
 */
public class AppointmentGUI {
    
    JFrame frame;
    JButton submitButton;
    JTextField name, email, subject, message;
    JLabel namelabel, emaillabel, subjectlabel, messagelabel, supportImage;
    ImageIcon icon;
    
    public AppointmentGUI(JFrame previousFrame){
        icon = new ImageIcon("Images/logo.png");

        frame = new JFrame("Appointment");
        frame.setSize(400, 400);
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(193, 255, 114));
        frame.setLayout(null);
        frame.setResizable(false);
        
        
        
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
}
