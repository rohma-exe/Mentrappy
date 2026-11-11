package com.company.maingui;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SongLibrary {
    private String filePath;
    private int userRating;
    private Clip clip; // Added Clip instance variable

    public SongLibrary() {
        filePath = " ";
        userRating = 0;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


    public void setRating(String rating) {
        userRating = Integer.parseInt(rating);
    }

    public int getRating() {
        return userRating;
    }

    public void playSong() {
        File songFile = new File(filePath);
        if (!songFile.exists()) {
            System.out.println("The selected song file does not exist. Exiting.");
            return;
        }

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(songFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("Playing song...");

            // Create a separate thread for playback
            Thread playThread = new Thread(() -> {
                clip.start();
                // Wait for the song to finish
                while (clip.isRunning()) {
                    try {
                        Thread.sleep(100); // Sleep for a short duration
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            playThread.start(); // Start the thread

        } catch (UnsupportedAudioFileException e) {
            System.out.println("Unsupported audio file format.");
            System.out.println(e);
        } catch (LineUnavailableException e) {
            System.out.println("Line is unavailable for playback.");
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Error reading the audio file.");
            System.out.println(e);
        }
    }

    public void stopSong() {
        if (clip != null && clip.isRunning()) {
            System.out.println("Stopping song...");
            clip.stop();
            clip.close();
        }
    }

    public boolean userFeedback() {
        while (true) {
            if (userRating >= 1 && userRating <= 5) {
                return true;
            } else {
                return false;
            }
        }
    }



}
