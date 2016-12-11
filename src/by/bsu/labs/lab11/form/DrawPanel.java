package by.bsu.labs.lab11.form;

import by.bsu.labs.lab11.action.listener.MouseDrawListener;
import by.bsu.labs.lab11.action.listener.MouseDrawMotionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by amareelez on 8.12.16.
 */

public class DrawPanel extends JPanel {
    private ArrayList<ArrayList<Point>> lines = new ArrayList<>();
    private ArrayList<Color> colors = new ArrayList<>();
    private Color color;
    private Point mostDistant = new Point(0, 0);
    private BufferedImage background = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    public DrawPanel() {
        addMouseMotionListener(new MouseDrawMotionListener());
        addMouseListener(new MouseDrawListener());
        color = Color.RED;
    }

    @Override protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(background, 0, 0, null);
        for (ArrayList<Point> points : lines) {
            graphics.setColor(colors.get(lines.indexOf(points)));
            int[] x = new int[points.size()], y = new int[points.size()];
            int i = 0;
            for (Point p : points) {
                x[i] = p.x;
                y[i++] = p.y;
            }
            graphics.drawPolyline(x, y, points.size());
        }
    }

    public void newLine() {
        lines.add(new ArrayList<>());
        colors.add(color);
    }

    public void addPoint(Point p) {
        lines.get(lines.size() - 1).add(p);
        if (p.x > mostDistant.x) {
            mostDistant.x = p.x;
            setPreferredSize(new Dimension(mostDistant.x + 50, mostDistant.y + 50));
        }
        if (p.y > mostDistant.y) {
            mostDistant.y = p.y;
            setPreferredSize(new Dimension(mostDistant.x + 50, mostDistant.y + 50));
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void loadImage(BufferedImage image) {
        background = image;
        lines.clear();
        colors.clear();
        mostDistant = new Point(image.getWidth(), image.getHeight());
        setPreferredSize(new Dimension(mostDistant.x + 50, mostDistant.y + 50));
        repaint();
    }
}
