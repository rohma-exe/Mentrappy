/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutGUI {

    JFrame frame;
    ImageIcon icon;
    JLabel logo;
    JPanel panel;
    
    public AboutGUI(JFrame previousFrame) {
        
        icon = new ImageIcon("Images/logo.png");
        
        frame = new JFrame("About Us");
        frame.setSize(500, 400);
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(193, 255, 114));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);        
        
        icon = new ImageIcon("Images/aboutlogo.png");
        String text = "<html>"
                + "<p>We are a team of licensed therapists offering mental therapy services for individuals,"
                + "couples, families, and groups. Our therapy services cover areas such as anxiety, depression,"
                + "trauma, grief, relationship issues, and more. We use evidence-based therapies like CBT, DBT,"
                + "and ACT to address the mind, body, and spirit. Our goal is to empower our clients to take"
                + "charge of their mental health and develop coping skills to manage life's challenges. We"
                + "provide a non-judgmental and compassionate environment where you can feel heard,"
                + "understood, and supported. Contact us to schedule an appointment.</p>"
                + "</html>";
        
        logo = new JLabel(icon);
        logo.setText(text);
        logo.setFont(new Font("Arial", Font.ITALIC, 12));
        logo.setForeground(Color.BLACK);
        logo.setHorizontalTextPosition(JLabel.CENTER);
        logo.setVerticalTextPosition(JLabel.BOTTOM);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setIconTextGap(20);
        
        panel = new JPanel();
        panel.setBackground(new Color(193, 255, 114));
        panel.setLayout(new BorderLayout(0, 0));
        panel.add(logo);
        panel.setBounds(30, 0, 425, 330);
        
        frame.add(panel);
        frame.setResizable(false);
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
}
