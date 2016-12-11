package by.bsu.labs.lab12.applet.action.listener;

import by.bsu.labs.lab12.applet.StringViewer;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by amareelez on 11.12.16.
 */

public class MouseDragDropListener extends MouseMotionAdapter {
    private Point location, previous;
    private boolean follow, active;
    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override public void mouseReleased(MouseEvent mouseEvent) {
            super.mouseReleased(mouseEvent);

            previous = null;
            follow = false;
        }
    };

    public MouseDragDropListener(Point location) {
        super();

        this.location = location;
        this.previous = null;
        this.follow = this.active = false;
    }

    @Override public void mouseDragged(MouseEvent mouseEvent) {
        super.mouseDragged(mouseEvent);

        if (!active) {
            return;
        }

        StringViewer stringViewer = (StringViewer) mouseEvent.getComponent();
        int h = stringViewer.getGraphics().getFontMetrics().getHeight() + 7, w = 7;
        String s = stringViewer.getData();
        for (int i = 0; i < s.length(); i++)
            w += stringViewer.getGraphics().getFontMetrics().charWidth(s.charAt(i));

        Point click = mouseEvent.getPoint();
        if (!follow && (click.x < location.x || click.x > location.x + w || click.y < location.y - h
            || click.y > location.y)) {
            return;
        }

        follow = true;
        if (previous == null) {
            previous = mouseEvent.getPoint();
            return;
        }

        location.x += mouseEvent.getX() - previous.x;
        location.y += mouseEvent.getY() - previous.y;
        previous = mouseEvent.getPoint();
        stringViewer.paint(stringViewer.getGraphics());
    }

    public MouseAdapter getReleaseAction() {
        return mouseAdapter;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
