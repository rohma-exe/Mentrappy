/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ProBook
 */


public class HomePageGUI extends JFrame implements ActionListener {

    JFrame frame;
    JPanel navBar;
    ImageIcon icon;
    JLabel logo;
    JButton login, register, contact, about;

    public HomePageGUI() {
        icon = new ImageIcon("Images/logo.png");

        frame = new JFrame("MentRappy");
        frame.setSize(1000, 700);
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(0, 0));
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        icon = new ImageIcon("Images/logo1.png");

        logo = new JLabel(icon);
        logo.setText("Mental Health Platform");
        logo.setFont(new Font("Arial", Font.ITALIC, 18));
        logo.setForeground(Color.BLACK);
        logo.setVerticalAlignment(JLabel.CENTER);
        logo.setHorizontalAlignment(JLabel.CENTER);
        logo.setIconTextGap(20);

        //creating login and signUp buttons
        login = new CustomButton("Login");
        register = new CustomButton("Register");
        contact = new CustomButton("Contact Us");
        about = new CustomButton("About Us");
        login.setForeground(Color.BLACK);
        login.setBackground(Color.WHITE);
        login.setFocusable(false);
        register.setForeground(Color.BLACK);
        register.setBackground(Color.WHITE);
        register.setFocusable(false);
        contact.setForeground(Color.BLACK);
        contact.setBackground(Color.WHITE);
        contact.setFocusable(false);
        about.setForeground(Color.BLACK);
        about.setBackground(Color.WHITE);
        about.setFocusable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(193, 255, 114));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 20)); // Align buttons to the right with gaps
        buttonPanel.add(login);
        buttonPanel.add(register);
        buttonPanel.add(contact);
        buttonPanel.add(about);

        // Create the navigation bar panel
        navBar = new JPanel();
        navBar.setBackground(new Color(193, 255, 114));
        navBar.setPreferredSize(new Dimension(frame.getWidth(), 65));
        navBar.setLayout(new BorderLayout());

        navBar.add(logo, BorderLayout.WEST);
        navBar.add(buttonPanel, BorderLayout.EAST); // Add buttonPanel to the right side of navBar

        // Create a container panel for the center panels
        JPanel centerContainer = new JPanel();
        centerContainer.setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("images/bg.png");
        JLabel image = new JLabel(icon);
        image.setSize(centerContainer.getWidth(), centerContainer.getHeight());

        centerContainer.add(image);

        //Adding Copy Rights Label at South Region
        int copyrightSymbolCodePoint = 169;
        String s = Character.toString(copyrightSymbolCodePoint);
        JLabel rightsLabel = new JLabel("Copyright " + s + " 2023,The Mental Health Platform, All rights reserved.");
        rightsLabel.setFont(new Font("Arial", Font.BOLD, 12));
        rightsLabel.setForeground(Color.BLACK);
        rightsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightsLabel.setBackground(Color.WHITE);

        JLabel contributionLabel = new JLabel("Developed by FA22-BSE-019| FA22-BSE-029| FA22-BSE-039");
        contributionLabel.setFont(new Font("Arial", Font.BOLD, 15));
        contributionLabel.setForeground(Color.BLACK);
        contributionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contributionLabel.setBackground(Color.WHITE);

        //Creating panel for south region
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.setBackground(new Color(56, 177, 70));
        bottomPanel.add(rightsLabel, BorderLayout.NORTH);
        bottomPanel.add(contributionLabel, BorderLayout.CENTER);

        login.addActionListener(this);
        register.addActionListener(this);
        contact.addActionListener(this);
        about.addActionListener(this);
        frame.add(navBar, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(centerContainer, BorderLayout.CENTER);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == register) {
            new RegisterGUI(frame);
        } else if (e.getSource() == login) {
            new LoginGUI(frame);
        } else if (e.getSource() == contact) {
            new ContactGUI(frame);
        } else if (e.getSource() == about) {
            new AboutGUI(frame);
        }

    }

}
