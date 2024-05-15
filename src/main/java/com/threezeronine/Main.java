package com.threezeronine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    public Main() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton fileButton = new JButton("File");
        JButton loadButton = new JButton("Load");
        JButton runButton = new JButton("Run");
        JButton statsButton = new JButton("Statistics");
        JButton exitButton = new JButton("Exit");

        panel.add(fileButton);
        panel.add(loadButton);
        panel.add(runButton);
        panel.add(statsButton);
        panel.add(exitButton);

        fileButton.addActionListener(this);
        loadButton.addActionListener(this);
        runButton.addActionListener(this);
        statsButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(panel, BorderLayout.NORTH);
        Canvas canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);

        Handler handler = new Handler();
        canvas.addMouseListener(handler);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("Connecting the Dots");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1000, 500);
        main.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("File")) {
            // insert file method here
        } else if (e.getActionCommand().equals("Load")) {
            // insert load method here
        } else if (e.getActionCommand().equals("Run")) {
            // insert run method here
        } else if (e.getActionCommand().equals("Statistics")) {
            // insert statistics method here
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        } 
    }
}