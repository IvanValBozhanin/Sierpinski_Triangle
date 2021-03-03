package com.company;

import java.awt.*;

import javax.swing.JPanel;

public class SierpinskiTrianglePanel extends JPanel {
    static double r = 0, gr = 150, b = 255;
    private int order = 0;

    /** Set a new order */
    public void setOrder(int order) {
        this.order = order;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Select three points in proportion to the panel size
        Point p1 = new Point(getWidth() / 2, 10);
        Point p2 = new Point(10, getHeight() - 10);
        Point p3 = new Point(getWidth() - 10, getHeight() - 10);
        displayTriangles(g, order, p1, p2, p3);
    }

    private void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3) {
        if (order == 0) {
            // Draw a triangle to connect three points
            double r = (p1.x*p1.x + p1.y*p1.y);
            double d = super.getWidth() * super.getWidth() + super.getHeight()*super.getHeight();
            double rat = Math.sqrt(r/d);
            System.out.println(r+ " " + d + " " + rat);
            g.setColor(new Color((int) (100*rat), (int) (150*rat), (int)(255*rat)));
            g.fillPolygon(new int[]{p1.x, p2.x, p3.x}, new int[]{p1.y, p2.y, p3.y}, 3);
        } else {
            // Get the midpoint on each edge of the triangle
            Point p12 = midpoint(p1, p2);
            Point p23 = midpoint(p2, p3);
            Point p31 = midpoint(p3, p1);
            // Recursively display three triangles
            displayTriangles(g, order - 1, p1, p12, p31);
            displayTriangles(g, order - 1, p12, p2, p23);
            displayTriangles(g, order - 1, p31, p23, p3);
        }
    }

    private static Point midpoint(Point p1, Point p2) {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}