package com.company.maingui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SongLibraryGUI extends JFrame implements ActionListener {

    JFrame songFrame;
    ImageIcon icon, back, image ,stars;
    JButton artist, artist1, artist2, genre, genre1, genre2, backA, backG, stop, rate, submit;
    JLabel songlabel, artistlabel, genrelabel, songImage, slabel ,rlabel, rateImage, rating, message;
    JTextField ratingField;
    SongLibrary songLibrary = new SongLibrary();

    public SongLibraryGUI(JFrame previousFrame) {
        icon = new ImageIcon("Images/logo.png");
        back = new ImageIcon("Images/back.png");

        songFrame = new JFrame("Song Library");
        songFrame.setSize(300, 300);
        songFrame.setIconImage(icon.getImage());
        songFrame.setLocationRelativeTo(null);
        songFrame.getContentPane().setBackground(new Color(193, 255, 114));
        songFrame.setLayout(null);
        songFrame.setResizable(false);

        songlabel = new JLabel("Search song by: ");
        songlabel.setVerticalTextPosition(JLabel.BOTTOM);
        songlabel.setBounds(100, 20, 180, 20);

        artist = new CustomButton("Artist");
        artist.setBounds(70, 70, 160, 40);
        artist.setForeground(Color.BLACK);
        artist.setBackground(Color.WHITE);
        artist.setFocusable(false);
        artist.addActionListener(this);
        genre = new CustomButton("Genre");
        genre.setBounds(70, 150, 160, 40);
        genre.setForeground(Color.BLACK);
        genre.setBackground(Color.WHITE);
        genre.setFocusable(false);
        genre.addActionListener(this);

        backA = new JButton();
        backA.setIcon(back);
        backA.setBounds(5, 5, 40, 40);
        backA.setOpaque(false);
        backA.setContentAreaFilled(false);
        backA.setBorderPainted(false);
        backA.addActionListener(this);

        backG = new JButton();
        backG.setIcon(back);
        backG.setBounds(5, 5, 40, 40);
        backG.setOpaque(false);
        backG.setContentAreaFilled(false);
        backG.setBorderPainted(false);
        backG.addActionListener(this);

        artistlabel = new JLabel("Select Artist: ");
        artistlabel.setVerticalTextPosition(JLabel.BOTTOM);
        artistlabel.setBounds(110, 20, 180, 20);

        artist1 = new CustomButton("Taylor Swift");
        artist1.setBounds(70, 70, 160, 40);
        artist1.setForeground(Color.BLACK);
        artist1.setBackground(Color.WHITE);
        artist1.setFocusable(false);
        artist1.addActionListener(this);

        artist2 = new CustomButton("Selena Gomez");
        artist2.setBounds(70, 150, 160, 40);
        artist2.setForeground(Color.BLACK);
        artist2.setBackground(Color.WHITE);
        artist2.setFocusable(false);
        artist2.addActionListener(this);

        genrelabel = new JLabel("Select genre: ");
        genrelabel.setVerticalTextPosition(JLabel.BOTTOM);
        genrelabel.setBounds(110, 20, 180, 20);

        genre1 = new CustomButton("Slow and Reverb");
        genre1.setBounds(70, 70, 160, 40);
        genre1.setForeground(Color.BLACK);
        genre1.setBackground(Color.WHITE);
        genre1.setFocusable(false);
        genre1.addActionListener(this);

        genre2 = new CustomButton("Motivation");
        genre2.setBounds(70, 150, 160, 40);
        genre2.setForeground(Color.BLACK);
        genre2.setBackground(Color.WHITE);
        genre2.setFocusable(false);
        genre2.addActionListener(this);

        image = new ImageIcon("Images/player.png");
        songImage = new JLabel();
        songImage.setIcon(image);
        songImage.setBounds(90, 0, image.getIconWidth(), image.getIconHeight());
        slabel = new JLabel("Now Playing... ");
        slabel.setVerticalTextPosition(JLabel.BOTTOM);
        slabel.setBounds(105, 10 + image.getIconHeight(), 180, 20);

        stop = new CustomButton("Stop");
        stop.setBounds(65, 150, 60, 30);
        stop.setForeground(Color.BLACK);
        stop.setBackground(Color.WHITE);
        stop.setFocusable(false);
        stop.addActionListener(this);

        rate = new CustomButton("Rate");
        rate.setBounds(160, 150, 60, 30);
        rate.setForeground(Color.BLACK);
        rate.setBackground(Color.WHITE);
        rate.setFocusable(false);
        rate.addActionListener(this);

        stars = new ImageIcon("Images/stars.png");
        rateImage = new JLabel();
        rateImage.setIcon(stars);
        rateImage.setBounds(90, 0, image.getIconWidth(), image.getIconHeight());
        rlabel = new JLabel("Rate from 1 (bad) to 5 (good)");
        rlabel.setForeground(Color.BLACK);
        rlabel.setVerticalTextPosition(JLabel.BOTTOM);
        rlabel.setBounds(60, image.getIconHeight(), 180, 20);

        rating = new JLabel();
        rating.setText("Rate:");
        rating.setBounds(50, 145, 100, 20);
        rating.setForeground(Color.BLACK);
        ratingField = new JTextField();
        ratingField.setBounds(100, 145, 140, 25);


        submit = new JButton("Submit");
        submit.setBounds(100, 190, 100, 30);
        submit.setForeground(Color.BLACK);
        submit.setBackground(Color.WHITE);
        submit.setFocusable(false);
        submit.addActionListener(this);

        message= new JLabel("Thank You for rating our song!");
        message.setForeground(Color.BLACK);
        message.setVerticalTextPosition(JLabel.BOTTOM);
        message.setBounds(60, 105, 180, 20);

        songFrame.add(songlabel);
        songFrame.add(artist);
        songFrame.add(genre);
        songFrame.setVisible(true);

        // Add WindowListener to perform actions when the frame is closed
        songFrame.addWindowListener(new java.awt.event.WindowAdapter() {
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
        if (e.getSource() == artist) {
            songFrame.remove(songlabel);
            songFrame.remove(artist);
            songFrame.remove(genre);
            songFrame.add(artist1);
            songFrame.add(artist2);
            songFrame.add(artistlabel);
            songFrame.add(backA);
            songFrame.revalidate();
            songFrame.repaint();
        } else if (e.getSource() == genre) {
            songFrame.remove(artist);
            songFrame.remove(genre);
            songFrame.remove(songlabel);
            songFrame.add(genre1);
            songFrame.add(genre2);
            songFrame.add(genrelabel);
            songFrame.add(backG);
            songFrame.revalidate();
            songFrame.repaint();
        } else if (e.getSource() == backA){
            songFrame.remove(artist1);
            songFrame.remove(artist2);
            songFrame.remove(artistlabel);
            songFrame.remove(backA);
            songFrame.add(artist);
            songFrame.add(genre);
            songFrame.add(songlabel);
            songFrame.revalidate();
            songFrame.repaint();
        } else if (e.getSource() == backG){
            songFrame.remove(genre1);
            songFrame.remove(genre2);
            songFrame.remove(genrelabel);
            songFrame.remove(backG);
            songFrame.add(artist);
            songFrame.add(genre);
            songFrame.add(songlabel);
            songFrame.revalidate();
            songFrame.repaint();
        } else if(e.getSource() == artist1){
            songFrame.remove(artist1);
            songFrame.remove(artist2);
            songFrame.remove(artistlabel);
            songFrame.remove(backA);
            songFrame.add(songImage);
            songFrame.add(slabel);
            songFrame.add(stop);
            songFrame.add(rate);
            songFrame.revalidate();
            songFrame.repaint();
            songLibrary.setFilePath("D://MainGUI/Songs/lover.wav");
            songLibrary.playSong();
        } else if(e.getSource() == artist2){
            songFrame.remove(artist1);
            songFrame.remove(artist2);
            songFrame.remove(artistlabel);
            songFrame.remove(backA);
            songFrame.add(songImage);
            songFrame.add(slabel);
            songFrame.add(stop);
            songFrame.add(rate);
            songFrame.revalidate();
            songFrame.repaint();
            songLibrary.setFilePath("D://MainGUI/Songs/calmdown.wav");
            songLibrary.playSong();
        }else if(e.getSource() == genre1){
            songFrame.remove(genre1);
            songFrame.remove(genre2);
            songFrame.remove(genrelabel);
            songFrame.remove(backG);
            songFrame.add(songImage);
            songFrame.add(slabel);
            songFrame.add(stop);
            songFrame.add(rate);
            songFrame.revalidate();
            songFrame.repaint();
            songLibrary.setFilePath("D://MainGUI/Songs/slow.wav");
            songLibrary.playSong();
        } else if(e.getSource() == genre2){
            songFrame.remove(genre1);
            songFrame.remove(genre2);
            songFrame.remove(genrelabel);
            songFrame.remove(backG);
            songFrame.add(songImage);
            songFrame.add(slabel);
            songFrame.add(stop);
            songFrame.add(rate);
            songFrame.revalidate();
            songFrame.repaint();
            songLibrary.setFilePath("D://MainGUI/Songs/kgf.wav");
            songLibrary.playSong();
        } else if (e.getSource()==stop) {
            songLibrary.stopSong();
        } else if (e.getSource()==rate) {
            songFrame.remove(songImage);
            songFrame.remove(slabel);
            songFrame.remove(stop);
            songFrame.remove(rate);
            songFrame.add(rateImage);
            songFrame.add(rlabel);
            songFrame.add(rating);
            songFrame.add(ratingField);
            songFrame.add(submit);
            songFrame.revalidate();
            songFrame.repaint();
        } else if (e.getSource()==submit) {
            songLibrary.setRating(ratingField.getText());
            if (!songLibrary.userFeedback()) {
                JOptionPane.showMessageDialog(null, "Invalid Number. Enter a number between 1 and 5", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                songFrame.remove(rateImage);
                songFrame.remove(rlabel);
                songFrame.remove(rating);
                songFrame.remove(ratingField);
                songFrame.remove(submit);
                songFrame.add(message);
                songFrame.revalidate();
                songFrame.repaint();
            }
        }
    }



}
