package com.threezeronine;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author Fisher Lyon, Leo Rivera, Eric Berber
 */
public class Canvas extends JPanel implements PropertyChangeListener {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : Repository.getInstance().getList()){
            point.draw(g);
        }
        Line line = new Line();
        line.draw(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
    
}
