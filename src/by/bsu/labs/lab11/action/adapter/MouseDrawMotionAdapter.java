package by.bsu.labs.lab11.action.adapter;

import by.bsu.labs.lab11.form.DrawPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by amareelez on 7.12.16.
 */

public class MouseDrawMotionAdapter extends MouseMotionAdapter {
    @Override public void mouseDragged(MouseEvent mouseEvent) {
        ((DrawPanel) mouseEvent.getComponent()).addPoint(mouseEvent.getPoint());
        mouseEvent.getComponent().repaint();
    }
}
