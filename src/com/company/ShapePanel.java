package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class ShapePanel extends JPanel {
     private final String shape;

    public ShapePanel(String shapeType){
        // Initialize shape
        shape = shapeType;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        // Prepare 2D graphic class prior to drawing each shape
        Graphics2D g2d = (Graphics2D) g.create();

        // Draw appropriate shape
        if(shape == "Equilateral Triangle"){
            Polygon poly = new Polygon(new int[] { 60, 85, 35 }, new int[] { 10, 60, 60 }, 3);
            g2d.setColor(Color.GREEN);
            g2d.fill(poly);
        } else if (shape == "Rectangle"){
            Polygon poly = new Polygon(new int[] { 15, 15, 95, 95 }, new int[] { 10, 60, 60, 10 }, 4);
            g2d.setColor(Color.YELLOW);
            g2d.fill(poly);
        } else if (shape == "Ellipse"){
            g2d.setColor(Color.ORANGE);
            g2d.fill(new Ellipse2D.Double(20, 15, 80, 45));
        } else if (shape == "Square"){
            Polygon poly = new Polygon(new int[] { 35, 35, 85, 85 }, new int[] { 10, 60, 60, 10 }, 4);
            g2d.setColor(Color.RED);
            g2d.fill(poly);
        } else { // Shape must be circle
            g2d.setColor(Color.BLUE);
            g2d.fill(new Ellipse2D.Double(33, 10, 50, 50));
        }

        // Clear system resources for graphics object
        g2d.dispose();
    }
}



