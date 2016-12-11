package by.bsu.labs.lab12.applet.action.listener;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by amareelez on 11.12.16.
 */

public class MouseDrawOnClickListener extends MouseAdapter {
    private Point location;

    public MouseDrawOnClickListener(Point location) {
        super();

        this.location = location;
    }

    @Override public void mouseClicked(MouseEvent mouseEvent) {

        location.x = mouseEvent.getX();
        location.y = mouseEvent.getY();
        mouseEvent.getComponent().paint(mouseEvent.getComponent().getGraphics());
    }
}
