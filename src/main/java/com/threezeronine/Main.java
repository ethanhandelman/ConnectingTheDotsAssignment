package com.threezeronine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Fisher Lyon, Leo Rivera, Eric Berber
 */
public class Main extends JFrame implements ActionListener {

    public Main() {
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton loadButton = new JButton("Load");
        JButton runButton = new JButton("Run");
        JButton statsButton = new JButton("Statistics");
        JButton exitButton = new JButton("Exit");

        panel.add(loadButton);
        panel.add(runButton);
        panel.add(statsButton);
        panel.add(exitButton);

        loadButton.addActionListener(this);
        runButton.addActionListener(this);
        statsButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(panel, BorderLayout.NORTH);
        Canvas canvas = new Canvas();
        add(canvas, BorderLayout.CENTER);

        Handler handler = new Handler();
        canvas.addMouseListener(handler);
        Repository.getInstance().setSize(getWidth(), getHeight());
        Repository.getInstance().addPropertyChangeListener(canvas);
        repaint();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("Connecting the Dots");
        main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.setSize(1000, 500);
        main.setVisible(true);
        Repository.getInstance().setSize(main.getWidth(), main.getHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Load")) {
            try {
                FileProcessor.read("test.tsp");
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getActionCommand().equals("Run")) {
            Repository.getInstance().repaint();
        } else if (e.getActionCommand().equals("Statistics")) {
            List<Point> ls = Repository.getInstance().getList();
            List<Point> corners = CalculateStat.findCornerPoints(ls);
            Point mid = CalculateStat.findMiddlePoint(ls);
            corners.add(mid);

            StatPanel statPanel = new StatPanel(corners);
            JFrame statFrame = new JFrame("Statistics");
            statFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            statFrame.add(statPanel);
            statFrame.pack();
            statFrame.setLocationRelativeTo(null);
            statFrame.setVisible(true);
        } else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        } 
    }
}
