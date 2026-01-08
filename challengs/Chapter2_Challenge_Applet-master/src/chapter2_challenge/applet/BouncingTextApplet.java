package chapter2_challenge.applet;

import java.applet.Applet;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {
    private final String name = "kidu"; // Replace with your actual name
    private int x = 0; // Starting x-coordinate
    private Thread thread;

    // Initialize the applet
    @Override
    public void init() {
        setSize(400, 200); // Set applet size
        setBackground(java.awt.Color.BLACK); // Set background color
    }

    // Start the thread
    @Override
    public void start() {
        thread = new Thread(this); // Create a new thread
        thread.start(); // Start the thread
    }

    // Stop the thread
    @Override
    public void stop() {
        thread = null; // Stop the thread
    }

    // The thread's run method
    @Override
    public void run() {
        while (true) {
            x += 5; // Update the x-coordinate

            // If the text hits the right edge, reset its position
            if (x > getWidth()) {
                x = 0;
            }

            repaint(); // Request to repaint the applet

            try {
                Thread.sleep(100); // Pause the animation for 100 milliseconds
            } catch (InterruptedException e) {
                // Handle interruption
                Thread.currentThread().interrupt();
            }
        }
    }

    // Paint the applet
    @Override
    public void paint(Graphics g) {
        g.setColor(java.awt.Color.WHITE); // Set text color
        g.drawString(name, x, 100); // Draw the text at the current x-coordinate
    }
}