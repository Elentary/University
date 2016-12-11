package by.bsu.labs.lab12.applet;

import javax.swing.*;
import java.awt.*;

/**
 * Created by amareelez on 11.12.16.
 */

public class StringViewer extends JApplet {
    private String data = "Hello";
    private Point location;

    @Override public void init() {
        super.init();

        //setBackground(Color.LIGHT_GRAY);

        //addMouseMotionListener(new MouseStatusCoordinatesListener());
        //addKeyListener(new KeyStringEditListener());
        //addKeyListener(new KeyCtrlPressedListener());
    }

    @Override public void start() {
        super.start();
        //location = new Point((int) getSize().getWidth() / 2, (int) getSize().getHeight() / 2);
        //addMouseListener(new MouseDrawOnClickListener(location));

        //MouseDragDropListener listener = new MouseDragDropListener(location);
        //addMouseListener(listener.getReleaseAction());
        //addMouseMotionListener(listener);

        //setFocusable(true);
    }

    @Override public void paint(Graphics graphics) {
        super.paint(graphics);
        //   graphics.drawString(data, location.x, location.y);
    }

    public String getData() {
        return data;
    }

    public void setData(String s) {
        data = s;
    }
}
