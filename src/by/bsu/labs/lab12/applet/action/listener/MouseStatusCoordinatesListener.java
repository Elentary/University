package by.bsu.labs.lab12.applet.action.listener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by amareelez on 11.12.16.
 */

public class MouseStatusCoordinatesListener extends MouseMotionAdapter {

    @Override public void mouseMoved(MouseEvent mouseEvent) {
        super.mouseMoved(mouseEvent);
        ((JApplet) mouseEvent.getComponent())
            .showStatus(String.format("(%d,%d)", mouseEvent.getX(), mouseEvent.getY()));
    }
}
