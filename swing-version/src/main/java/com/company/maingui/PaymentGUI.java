/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.maingui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ProBook
 */


public class PaymentGUI extends JFrame implements ActionListener {

    JFrame paymmentFrame;
    JButton submitButton;
    JTextField cardNum, cvv, expiry, amount;
    JLabel paymentlabel, cardlabel, cvvlabel, expirylabel,amountlabel,paymentImage;
    ImageIcon icon, image;

    public PaymentGUI(JFrame previousFrame) {

        icon = new ImageIcon("Images/logo.png");

        paymmentFrame= new JFrame("Payment");
        paymmentFrame.setSize(400, 400);
        paymmentFrame.setIconImage(icon.getImage());
        paymmentFrame.setLocationRelativeTo(null);
        paymmentFrame.getContentPane().setBackground(new Color(193, 255, 114));
        paymmentFrame.setLayout(null);
        paymmentFrame.setResizable(false);


        image = new ImageIcon("Images/payment.png");
        paymentImage = new JLabel();
        paymentImage.setIcon(image);
        paymentImage.setBounds(130, 15, image.getIconWidth(), image.getIconHeight());
        paymentlabel = new JLabel("Enter Payment Details ");
        paymentlabel.setVerticalTextPosition(JLabel.BOTTOM);
        paymentlabel.setBounds(120, 10 + image.getIconHeight(), 180, 20);

        cardlabel = new JLabel();
        cardlabel.setText("Credit Card No. : ");
        cardlabel.setBounds(60, 150, 100, 20);
        cardNum = new JTextField();
        cardNum.setBounds(180, 150, 140, 25);
        cvvlabel = new JLabel();
        cvvlabel.setText("CVV: ");
        cvvlabel.setBounds(60, 180, 100, 20);
        cvv = new JTextField();
        cvv.setBounds(180, 180, 140, 25);
        expirylabel = new JLabel();
        expirylabel.setText("Expiration Date: ");
        expirylabel.setBounds(60, 210, 100, 20);
        expiry = new JTextField();
        expiry.setBounds(180, 210, 140, 25);
        amountlabel = new JLabel();
        amountlabel.setText("Amount: ");
        amountlabel.setBounds(60, 240, 100, 20);
        amount = new JTextField();
        amount.setBounds(180, 240, 140, 25);


        submitButton = new CustomButton("Submit");
        submitButton.setBounds(150, 290, 80, 30);
        submitButton.setForeground(Color.BLACK);
        submitButton.setBackground(Color.WHITE);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        //adding content to Frame;
        paymmentFrame.add(paymentImage);
        paymmentFrame.add(paymentlabel);
        paymmentFrame.add(cardlabel);
        paymmentFrame.add(cardNum);
        paymmentFrame.add(cvvlabel);
        paymmentFrame.add(cvv);
        paymmentFrame.add(expirylabel);
        paymmentFrame.add(expiry);
        paymmentFrame.add(submitButton);
        paymmentFrame.add(amountlabel);
        paymmentFrame.add(amount);
        paymmentFrame.setVisible(true);

        // Add WindowListener to perform actions when the frame is closed
        paymmentFrame.addWindowListener(new java.awt.event.WindowAdapter() {
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
        Payment payment = new Payment();
        String cardnumtext = cardNum.getText();
        String cvvtext = cvv.getText();
        String expirytext = expiry.getText();
        String amounttext= amount.getText();

        if (payment.checkCard(cardnumtext)) {
            JOptionPane.showMessageDialog(null, "Invalid Card Number. Enter a 16 digit card number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (payment.checkCvv(cvvtext)) {
            JOptionPane.showMessageDialog(null, "Invalid CVV. Enter 3 digit CVV.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (payment.checkExpiry(expirytext)) {
            JOptionPane.showMessageDialog(null, "Invalid Expiry Date. ", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else if (payment.checkAmount(amounttext)) {
            JOptionPane.showMessageDialog(null, "Amount should be greater than 0.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            //what happens after correct payment

        }
    }
}
