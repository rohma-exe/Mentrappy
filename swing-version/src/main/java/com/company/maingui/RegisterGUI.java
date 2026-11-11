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

/**
 *
 * @author ProBook
 */
public class RegisterGUI extends JFrame implements ActionListener {

    JFrame frame, previousFrame;
    ImageIcon icon;
    JButton patient, doctor;

    public RegisterGUI(JFrame previousFrame) {
        this.previousFrame = previousFrame;
        icon = new ImageIcon("Images/logo.png");

        frame = new JFrame("Register");
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
            int previousX = previousFrame.getX();
            int previousY = previousFrame.getY();
            int previousWidth = previousFrame.getWidth();
            int previousHeight = previousFrame.getHeight();
            int x = previousX + (previousWidth - 500) / 2; // Calculate x position
            int y = previousY + (previousHeight - 500) / 2; // Calculate y position
            frame.setSize(500, 500);
            frame.setLocation(x, y);
        } else if (e.getSource() == doctor) {
            int previousX = previousFrame.getX();
            int previousY = previousFrame.getY();
            int previousWidth = previousFrame.getWidth();
            int previousHeight = previousFrame.getHeight();
            int x = previousX + (previousWidth - 500) / 2; // Calculate x position
            int y = previousY + (previousHeight - 500) / 2; // Calculate y position
            frame.setSize(500, 500);
            frame.setLocation(x, y);
        }
    }

}
